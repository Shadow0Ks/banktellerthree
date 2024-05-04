import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.Arrays;

public class AnimationWorkingScreen extends JFrame {

    public static int SCREEN_WIDTH = 800;
    public static int SCREEN_HEIGHT = 600;
    private String csvFile = "src\\customer_data.csv";
    private JTextArea textArea;

    private ScreenButtons screenButtons;

    public AnimationWorkingScreen(){

        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Bank Teller - Working man Screen");
        //setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

//        screenButtons = new ScreenButtons();
//        screenButtons.ToNextMonth(this);


        //loads the gif
        ImageIcon icon = new ImageIcon("src\\working_man.gif");
        //resizes the gif


        Image scaledImage = icon.getImage().getScaledInstance(SCREEN_WIDTH,SCREEN_HEIGHT, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel label = new JLabel(scaledIcon);
        panel.add(label, BorderLayout.CENTER);
        add(panel);


        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3 && e.getClickCount() == 2) {
                    updateBalanceAndWriteToCSV(2000);
                    dispose();
                    CustomerIDSearch customerIDSearch = new CustomerIDSearch();
                    customerIDSearch.setVisible(true);
                }
            }
        });

        setVisible(true);

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


}
