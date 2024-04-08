import javax.swing.*;

public class CustomerInformationScreen extends JFrame {
    public static int SCREEN_WIDTH = 800;
    public static int SCREEN_HEIGHT = 600;


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

        setLayout(null);

    }

    public static void displayCustomerInfo(String[] customerInfo){
        JFirstName.setText("First Name: " + customerInfo[0]);
        JLastName.setText("Last Name: " + customerInfo[1]);
        JMoneyInBank.setText("Money in Bank: " + customerInfo[2]);
        JCreditScore.setText("Your Credit Score: " + customerInfo[3]);
        JCustomerID.setText("4 digit number ID: " + customerInfo[4]);

    }
}
