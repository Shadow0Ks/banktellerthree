import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Arrays;

public class DepositScreen extends JFrame {
    public static int SCREEN_WIDTH = 800;
    public static int SCREEN_HEIGHT = 600;
    private String csvFile = "src/customer_data.csv";

    private ScreenButtons screenButtons;

    static double DepositAmount;
    private String customerID;
    static JLabel JDepositMoney;
    private JTextField depositTextField;
    final private Font getCustomFont = FontLoader.loadFont("src\\minecraft.ttf", Font.PLAIN, 20);

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
        //font = new Font("Arial", Font.ITALIC, calculateFontSize() + 2);

        int labelX = 100;
        int labelY = 50;
        int labelWidth = 500;
        int labelHeight = 30;
        int gap = 10;

        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds((SCREEN_WIDTH - 100) / 2, 200, 100, 30);
        depositButton.addActionListener(e -> {
            String depositText = depositTextField.getText().trim();
            if (!depositText.isEmpty()) {
                try {
                    double depositAmount = Double.parseDouble(depositText);
                    if (depositAmount >= 0) {
                        updateBalanceAndWriteToCSV(depositAmount);
                    } else {
                        System.out.println("Please enter a valid deposit amount.");
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Please enter a valid numeric deposit amount.");
                }
            } else {
                System.out.println("Please enter a valid deposit amount.");
            }
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
        depositTextField.setEnabled(true); // Ensure it's enabled
        depositTextField.requestFocusInWindow(); // Set focus to the text field
        add(depositTextField);

    }


    private int calculateFontSize() {
        int screenSize = getWidth() * getHeight();
        int fontSize = (int) (Math.sqrt(screenSize) / 50);
        return fontSize;
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
        drawRectangles(graphics);
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
            double currentBalance = Double.parseDouble(customerData[2]);
            currentBalance += depositAmount;
            customerData[2] = String.valueOf(currentBalance); // Update balance in customer data
            writeToCSV(Arrays.toString(customerData).replaceAll("[\\[\\]]", ""));
        } else {
            System.out.println("Customer not found.");
        }
    }

}




