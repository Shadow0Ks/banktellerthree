import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class DepositScreen extends JFrame{
    public static int SCREEN_WIDTH = 800;
    public static int SCREEN_HEIGHT = 600;

    private ScreenButtons screenButtons;

    static int DepositAmount;
    private String customerID;
    static JLabel JDepositMoney;
    private JTextField depositTextField;
    private Font font;

    private String[] customerInfo;
    String csvFile = "src\\customer_data.csv";
    public DepositScreen(){

        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Bank  - Deposit");
        setLocationRelativeTo(null);
        setVisible(true);

        setLayout(null);
    }
    void drawRectangles(Graphics graphics){
        depositScreenContent(graphics);
        screenButtons = new ScreenButtons();
        //this needs to be fixed the reason that it doesnt work is because I cant use "this" because it refrences another class, look for a solution(Make it dynamic or copy the exact same class)
        //screenButtons.ButtonThatTakesBackToWelcomeScreen();
    }
    public void depositScreenContent(Graphics graphics){
        font = new Font("Arial", Font.ITALIC, calculateFontSize() + 2);

        int labelX = 100;
        int labelY = 50;
        int labelWidth = 500;
        int labelHeight = 30;
        int gap = 10;

        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds((SCREEN_WIDTH - 100) / 2, 200, 100, 30);
        depositButton.addActionListener(e -> writeToCSV() );
        add(depositButton);

        JDepositMoney = new JLabel("How much would you like to deposit: ");
        JDepositMoney.setFont(font);
        JDepositMoney.setBounds(labelX,labelY,labelWidth,labelHeight);
        add(JDepositMoney);
        JDepositMoney.setVisible(true);

        int textFieldWidth = 200;
        int textFieldHeight = 30;
        depositTextField = new JTextField();
        depositTextField.setBounds((SCREEN_WIDTH - textFieldWidth) / 2, 150, textFieldWidth, textFieldHeight);
        add(depositTextField);

    }


    private int calculateFontSize(){
        int screenSize = getWidth() * getHeight();
        int fontSize = (int)(Math.sqrt(screenSize) / 50);
        return fontSize;
    }

    public void paint(Graphics graphics){
        super.paint(graphics);
        drawRectangles(graphics);
    }
    private void writeToCSV() {
        System.out.println("Before getting text from depositTextField");
        String depositStr = depositTextField.getText();
        System.out.println("Input deposit string: \"" + depositStr + "\""); // Debug statement
        System.out.println("After getting text from depositTextField");

        if (depositStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a valid deposit amount.");
            return;
        }

        try {
            double depositAmount = Double.parseDouble(depositStr);

            // Open the original file for reading and writing
            File file = new File(csvFile);
            File tempFile = new File("temp.csv");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            boolean depositMade = false; // Flag to track if deposit was made for any user
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 5) {
                    double currentBalance = Double.parseDouble(data[2]);
                    currentBalance += depositAmount;
                    data[2] = String.valueOf(currentBalance);
                    depositMade = true; // Set flag to true if deposit is made
                }
                writer.write(String.join(",", data) + System.lineSeparator());
            }

            reader.close();
            writer.close();

            if (!depositMade) {
                JOptionPane.showMessageDialog(this, "No user found in the CSV file to deposit money.");
                tempFile.delete(); // Delete the temp file if no deposit is made
            } else {
                file.delete(); // Delete the original file
                tempFile.renameTo(file); // Rename the temp file to the original file
                JOptionPane.showMessageDialog(this, "Deposit successful!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid deposit amount. Please enter a valid number.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error occurred while depositing money.");
            e.printStackTrace();
        }
    }

}
