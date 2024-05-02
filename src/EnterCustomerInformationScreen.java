import javax.swing.*;
import java.awt.*;

public class EnterCustomerInformationScreen extends JFrame {
    public static int SCREEN_WIDTH = 1000;
    public static int SCREEN_HEIGHT = 1000;

    private ScreenButtons screenButtonsNextPage;

    final private Font getCustomFont = FontLoader.loadFont("src\\ProximaNova.otf", Font.PLAIN, 20);
    static JTextField TextFirstName;
    static JTextField TextLastName;
    static JTextField TextMoneyBox;
    static JTextField TextCreditScore;
    static JTextField TextCustomerID;

    public EnterCustomerInformationScreen(){
        setTitle("Bank Teller - Enter Your Information");
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);

        TextFields();


    }
    public void TextFields(){


        //aaaa
        setLayout(new GridLayout(6, 2, 3, 5));

        JLabel JFirstName = new JLabel("First Name:");
        JFirstName.setFont(getCustomFont);
        add(JFirstName);
        TextFirstName = new JTextField();
        TextFirstName.setFont(getCustomFont);
        add(TextFirstName);


        JLabel JLastName = new JLabel("Last Name:");
        JLastName.setFont(getCustomFont);
        add(JLastName);
        TextLastName = new JTextField();
        TextLastName.setFont(getCustomFont);
        add(TextLastName);

        JLabel JMoneyInBank = new JLabel("Money to deposit in Bank:");
        JMoneyInBank.setFont(getCustomFont);
        add(JMoneyInBank);
        TextMoneyBox = new JTextField();
        TextMoneyBox.setFont(getCustomFont);
        add(TextMoneyBox);

        JLabel JCreditScore = new JLabel("Your Credit Score:");
        JCreditScore.setFont(getCustomFont);
        add(JCreditScore);
        TextCreditScore = new JTextField();
        TextCreditScore.setFont(getCustomFont);
        add(TextCreditScore);

        JLabel JCustomerID = new JLabel("Give yourself a 4 digit number ID:");
        JCustomerID.setFont(getCustomFont);
        add(JCustomerID);
        TextCustomerID = new JTextField();
        TextCustomerID.setFont(getCustomFont);
        add(TextCustomerID);



        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        //Place holder



        screenButtonsNextPage = new ScreenButtons();
        screenButtonsNextPage.NextPageSaveCustomerInfoButton(this);
    }

    public static void saveCustomerInfo(){
        String firstName = TextFirstName.getText();
        String lastName = TextLastName.getText();
        String moneyBox = TextMoneyBox.getText();
        String creditScore = TextCreditScore.getText();
        String customerID = TextCustomerID.getText();
        CSVCustomerData.writeDataToCSV(firstName, lastName, moneyBox, creditScore, customerID);

    }



}
