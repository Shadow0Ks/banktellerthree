import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class DepositScreen extends JFrame {
    public static int SCREEN_WIDTH = 800;
    public static int SCREEN_HEIGHT = 600;
    private String csvFile = "src\\customer_data.csv";

    private ScreenButtons screenButtons;

    static double DepositAmount;
    private String customerID;
    static JLabel JDepositMoney;
    private JTextField depositTextField;
    //final private Font getCustomFont = FontLoader.loadFont("src\\minecraft.ttf", Font.PLAIN, 20);
    final private Font getCustomFont = new Font("Arial", Font.PLAIN, 20);
    private String[] customerInfo;

    public DepositScreen() {
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Bank  - Deposit");
        setLocationRelativeTo(null);
        setLayout(null);

        depositScreenContent();
    }


    void drawRectangles(Graphics graphics) {
        depositScreenContent();
        screenButtons = new ScreenButtons();
        //this needs to be fixed the reason that it doesnt work is because I cant use "this" because it refrences another class, look for a solution(Make it dynamic or copy the exact same class)
        //screenButtons.ButtonThatTakesBackToWelcomeScreen();
    }

    public void depositScreenContent() {
        int labelX = 100;
        int labelY = 50;
        int labelWidth = 500;
        int labelHeight = 30;

        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds((SCREEN_WIDTH - 100) / 2, 200, 100, 30);
        depositButton.addActionListener(e -> {
            double depositAmount = Double.parseDouble(depositTextField.getText().trim());
            updateBalanceAndWriteToCSV(depositAmount);

            CustomerIDSearch searchScreen = new CustomerIDSearch();
            searchScreen.setVisible(true);
            dispose(); // Close the deposit screen
        });
        add(depositButton);

        JDepositMoney = new JLabel("How much would you like to deposit: ");
        JDepositMoney.setFont(getCustomFont);
        JDepositMoney.setBounds(labelX, labelY, labelWidth, labelHeight);
        add(JDepositMoney);
        JDepositMoney.setVisible(true);

        int textFieldWidth = 200;
        int textFieldHeight = 30;
        depositTextField = new JTextField();
        depositTextField.setBounds((SCREEN_WIDTH - textFieldWidth) / 2, 150, textFieldWidth, textFieldHeight);
        depositTextField.setEnabled(true);
        depositTextField.requestFocusInWindow();
        add(depositTextField);

        depositTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateInput();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateInput();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateInput();
            }
        });
    }

    private void validateInput() {
        String depositText = depositTextField.getText().trim();
        if (depositText.isEmpty()) {
            System.out.println("Please enter a valid deposit amount.");
        } else {
            try {
                double depositAmount = Double.parseDouble(depositText);
                if (depositAmount < 0) {
                    System.out.println("Please enter a non-negative deposit amount.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid numeric deposit amount.");
            }
        }
    }

    private String[] readCustomerData(String customerID) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))){
            String line;
            while ((line = br.readLine()) != null){
                String[] data = line.split(",");
                if (data.length > 4 && data[4].trim().equals(customerID)){
                    return data;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private void writeToCSV(String data) {
        try (FileWriter writer = new FileWriter(csvFile, true);
             BufferedWriter bw = new BufferedWriter(writer);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(data);
        } catch (IOException e) {
            System.err.println("Error writing to CSV file: " + e.getMessage());
        }
    }




    private void updateBalanceAndWriteToCSV(double depositAmount) {
        String customerID = "4491"; // Assuming a customer ID for testing
        String[] customerData = readCustomerData(customerID);
        if (customerData != null) {
            System.out.println("Customer Data:");
            System.out.println("First Name: " + customerData[0]);
            System.out.println("Last Name: " + customerData[1]);
            System.out.println("Money in Bank: " + customerData[2]);
            System.out.println("Credit Score: " + customerData[3]);
            System.out.println("Customer ID: " + customerData[4]);

            double currentBalance = Double.parseDouble(customerData[2]);
            currentBalance += depositAmount;
            customerData[2] = String.valueOf(currentBalance); // Update balance in customer data
            writeToCSV(Arrays.toString(customerData).replaceAll("[\\[\\]]", ""));
            //writeToCSV(customerData); //might change this
        } else {
            System.out.println("Customer not found.");
        }
    }


//    private void updateBalanceAndWriteToCSV(String customerID, double depositAmount) {
//        String[] customerData = readCustomerData(customerID);
//        if (customerData != null) {
//            // Update balance for the specific customer
//            double currentBalance = Double.parseDouble(customerData[2]);
//            currentBalance += depositAmount;
//            customerData[2] = String.valueOf(currentBalance); // Update balance in customer data
//
//            // Write the updated data back to the CSV file
//            writeToCSV(String.join(",", customerData));
//        } else {
//            System.out.println("Customer not found.");
//        }
//    }















    ////////////////////////////////////
//    private void updateBalanceAndWriteToCSV(double depositAmount) {
//        String customerID = "4491"; // Assuming a customer ID for testing
//        String[] customerData = readCustomerData(customerID);
//        if (customerData != null) {
//            System.out.println("Customer Data:");
//            System.out.println("First Name: " + customerData[0]);
//            System.out.println("Last Name: " + customerData[1]);
//            System.out.println("Money in Bank: " + customerData[2]);
//            System.out.println("Credit Score: " + customerData[3]);
//            System.out.println("Customer ID: " + customerData[4]);
//
//            double currentBalance = Double.parseDouble(customerData[2]);
//            currentBalance += depositAmount;
//            customerData[2] = String.valueOf(currentBalance); // Update balance in customer data
//
//            // Create a temporary file to store the updated content
//            String tempFileName = "src\\customer_data_temp.csv";
//
//            // Write the updated content to the temporary file
//            try (PrintWriter writer = new PrintWriter(new FileWriter(tempFileName))) {
//                try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
//                    String line;
//                    while ((line = br.readLine()) != null) {
//                        String[] data = line.split(",");
//                        if (data.length > 4 && data[4].trim().equals(customerID)) {
//                            writer.println(String.join(",", customerData));
//                        } else {
//                            writer.println(line);
//                        }
//                    }
//                } catch (IOException e) {
//                    System.err.println("Error reading CSV file: " + e.getMessage());
//                    return;
//                }
//            } catch (IOException e) {
//                System.err.println("Error writing to temporary file: " + e.getMessage());
//                return;
//            }
//
//            // Replace the original file with the temporary file
//            File originalFile = new File(csvFile);
//            File tempFile = new File(tempFileName);
//            if (tempFile.renameTo(originalFile)) {
//                System.out.println("Balance updated successfully.");
//            } else {
//                System.err.println("Error updating balance: Unable to replace the original file.");
//            }
//        } else {
//            System.out.println("Customer not found.");
//        }
//    }

}






