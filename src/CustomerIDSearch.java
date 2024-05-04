import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerIDSearch extends JFrame{
    public static int SCREEN_WIDTH = 800;
    public static int SCREEN_HEIGHT = 600;
    Sound sound = new Sound();
    static String file = "src\\customer_data.csv";
    final private Font getCustomFont = FontLoader.loadFont("src\\minecraft.ttf", Font.PLAIN, 20);


    static JTextField TextCustomerID;
    static JTextField IDTextField;
    static int creditScore;

    private ScreenButtons screenButtons;




    public CustomerIDSearch() {
        setTitle("Bank Teller - Enter Your ID");
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);

        IDTextField = new JTextField();
        IDTextField.setFont(getCustomFont);
        IDTextField.setBounds(200, 200, 200, 30);
        add(IDTextField);

        screenButtons = new ScreenButtons();
        screenButtons.ButtonThatTakesToInfoScreen(this);
    }
    public void CustomerIDScreenInfo(Graphics graphics){
        paintComponents(graphics);
        graphics.setFont(getCustomFont);
        graphics.setColor(Color.BLACK);
        String pageQuestion = "Enter your Customer ID";
        int x = (getWidth() - graphics.getFontMetrics().stringWidth(pageQuestion)) / 2;
        //positive is top of the screen
        //negative toward the bottom of the screen
        int y = getHeight() / 3;
        //display the text on the screen
        graphics.drawString(pageQuestion, x, y);



    }

    void drawRectangles(Graphics graphics){
        //x,y location of the rectangle
        //w,h size of it
        int rectWidth = 100;
        int rectHeight  = 50;
        int rectX = (SCREEN_WIDTH - rectWidth) / 2;
        int rectY = (SCREEN_HEIGHT - rectHeight) / 2;

        graphics.setColor(Color.BLACK);
        graphics.drawRect(rectX, rectY, rectWidth,rectHeight);
        CustomerIDScreenInfo(graphics);



    }

    public void paint(Graphics graphics){
        super.paint(graphics);
        drawRectangles(graphics);
    }



    public static void checkCustomerID() {
        String customerID = IDTextField.getText().trim(); // Trim to remove leading and trailing spaces
        boolean found = false;
        String[] customerInfo = null;
        ;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                System.out.println("Checking line: " + line);
                if (data.length > 4) {


                    String idFromFile = data[4].trim();
                    System.out.println("Data[4]: " + idFromFile);
                    System.out.println("Customer ID Entered: " + customerID);


                    if (idFromFile.equals(customerID)) {
                        found = true;
                        creditScore = Integer.parseInt(data[3].trim());


                        customerInfo = data;
                        //CustomerInformationScreen customerInformationScreen = new CustomerInformationScreen();

                        System.out.println("Customer found!");
                        break;
                    }
                }
            }
            if (!found) {
                System.out.println("Customer not found!");
                //make it send you back to the EnterCustomerInformationScreen
                AccountQuestionScreen accountQuestionScreen = new AccountQuestionScreen();
                SwingUtilities.getWindowAncestor(IDTextField).dispose();

            }
            else {
                // Display customer information in CustomerInformationScreen

                CustomerInformationScreen customerInformationScreen = new CustomerInformationScreen();
                customerInformationScreen.displayCustomerInfo(customerInfo);
                // Dispose the current frame
                SwingUtilities.getWindowAncestor(IDTextField).dispose();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
