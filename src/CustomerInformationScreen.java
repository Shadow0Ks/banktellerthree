import javax.swing.*;
import java.awt.*;

public class CustomerInformationScreen extends JFrame {
    public static int SCREEN_WIDTH = 800;
    public static int SCREEN_HEIGHT = 600;

    private ScreenButtons screenButtons;

    final private Font getCustomFont = FontLoader.loadFont("src\\minecraft.ttf", Font.PLAIN, 20);
    static JLabel JFirstName;
    static JLabel JLastName;
    static JLabel JMoneyInBank;
    static JLabel JCreditScore;
    static JLabel JCustomerID;
    public CustomerInformationScreen(){

        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Bank Teller - Customer Information");
        setLocationRelativeTo(null);
        setVisible(true);

        //setLayout(new BorderLayout());
        setLayout(null);


        //for setting positions on screen
        int labelX = 100;
        int labelY = 50;
        int labelWidth = 500;
        int labelHeight = 30;
        int gap = 10;
        ////////////////////////

//        JPanel formPanel = new JPanel();
//        formPanel.setLayout(new GridLayout(5, 1, 5, 5));

        JFirstName = new JLabel("First Name:");
        JFirstName.setFont(getCustomFont);
        JFirstName.setBounds(labelX,labelY,labelWidth,labelHeight);
        add(JFirstName);
        //formPanel.add(JFirstName);

        //adjusts for screen position
        labelY += labelHeight + gap;

        JLastName = new JLabel("Last Name:");
        JLastName.setFont(getCustomFont);
        JLastName.setBounds(labelX,labelY,labelWidth,labelHeight);
        add(JLastName);
        //formPanel.add(JLastName);


        //adjusts for screen position
        labelY += labelHeight + gap;
        JMoneyInBank = new JLabel("Money in Bank:");
        JMoneyInBank.setFont(getCustomFont);
        JMoneyInBank.setBounds(labelX,labelY,labelWidth,labelHeight);
        add(JMoneyInBank);
        //formPanel.add(JMoneyInBank);

        //adjusts for screen position
        labelY += labelHeight + gap;

        JCreditScore = new JLabel("Your Credit Score:");
        JCreditScore.setFont(getCustomFont);
        JCreditScore.setBounds(labelX,labelY,labelWidth,labelHeight);
        add(JCreditScore);
        //formPanel.add(JCreditScore);

        //adjusts for screen position
        labelY += labelHeight + gap;

        JCustomerID = new JLabel("4 digit number ID:");
        JCustomerID.setFont(getCustomFont);
        JCustomerID.setBounds(labelX,labelY,labelWidth,labelHeight);
        add(JCustomerID);
        //formPanel.add(JCustomerID);

        //add(formPanel, BorderLayout.CENTER);


        screenButtons = new ScreenButtons();
        screenButtons.TakeOutLoanButton(this);
        screenButtons.DepositMoneyButton(this);
        screenButtons.SetGoingToWorkButton(this);

    }


    public static void displayCustomerInfo(String[] customerInfo){
        JFirstName.setText("First Name: " + customerInfo[0]);
        JLastName.setText("Last Name: " + customerInfo[1]);
        JMoneyInBank.setText("Money in Bank: " + customerInfo[2]);
        JCreditScore.setText("Your Credit Score: " + customerInfo[3]);
        JCustomerID.setText("4 digit number ID: " + customerInfo[4]);

    }
}
