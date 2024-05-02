import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class DepositScreen extends JFrame{
    public static int SCREEN_WIDTH = 800;
    public static int SCREEN_HEIGHT = 600;

    private ScreenButtons screenButtons;

    static double DepositAmount;
    private String customerID;
    static JLabel JDepositMoney;
    private JTextField depositTextField;
    final private Font getCustomFont = FontLoader.loadFont("src\\ProximaNova.otf", Font.PLAIN, 20);

    private String[] customerInfo;
    String csvFile = "src\\customer_data.csv";
    public DepositScreen(){
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Bank  - Deposit");
        setLocationRelativeTo(null);
        setLayout(null);

        depositScreenContent();
    }


    void drawRectangles(Graphics graphics){
        depositScreenContent();
        screenButtons = new ScreenButtons();
        //this needs to be fixed the reason that it doesnt work is because I cant use "this" because it refrences another class, look for a solution(Make it dynamic or copy the exact same class)
        //screenButtons.ButtonThatTakesBackToWelcomeScreen();
    }
    public void depositScreenContent(){
        //font = new Font("Arial", Font.ITALIC, calculateFontSize() + 2);

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
        JDepositMoney.setFont(getCustomFont);
        JDepositMoney.setBounds(labelX,labelY,labelWidth,labelHeight);
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
        //check which customer I have pulled up from the CustomerInformationScreen
    }

}
