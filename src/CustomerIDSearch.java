import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerIDSearch extends JFrame{
    public static int SCREEN_WIDTH = 800;
    public static int SCREEN_HEIGHT = 600;
    static String file = "src\\customer_data.csv";
    final private Font mainFont = new Font ("Segeo Print", Font.BOLD, 18);
    static JTextField TextCustomerID;
    static JTextField IDTextField;

    private ScreenButtons screenButtons;




    public CustomerIDSearch() {
        setTitle("Bank Teller - Enter Your ID");
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);

        screenButtons = new ScreenButtons();
        screenButtons.ButtonThatTakesToInfoScreen(this);
    }
    public void CustomerIDScreenInfo(Graphics graphics){
        paintComponents(graphics);
        graphics.setFont(mainFont);
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

        IDTextFieldScreenDisplay();

    }

    public void paint(Graphics graphics){
        super.paint(graphics);
        drawRectangles(graphics);
    }


    public void IDTextFieldScreenDisplay(){

        setLayout(new GridLayout(10, 2, 3, 5));
        IDTextField = new JTextField();
        IDTextField.setFont(mainFont);
        add(IDTextField);
    }


    //call this class when next button page button is performed
    public void checkCustomerID() {
        String customerIDCheck = TextCustomerID.getText();
        boolean customerDoesExist = false;
        try (BufferedReader read = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = read.readLine()) != null) {
                String[] data = line.split(",");

                String customerID = data[4].trim();
                if (customerID.equals(customerIDCheck)) {
                    // Customer ID exists
                    System.out.println("Customer ID does exist");
                    customerDoesExist = true;

                    // Create an ArrayList to store customer information
                    List<String> customerInfo = new ArrayList<>();

                    for (int i = 0; i < data.length; i++) {
                        customerInfo.add(data[i]);
                    }

                    // Display customer information on the infoscreen
                    CustomerInformationScreen infroScreen = new CustomerInformationScreen();
                    infroScreen.displayCustomerInfo(customerInfo.toArray(new String[0]));

                    dispose();
                    break;
                }
            }

            if (!customerDoesExist) {
                // Customer ID does not exist
                System.out.println("Customer ID does not Exist");
                dispose();
                AccountQuestionScreen aq = new AccountQuestionScreen();
                aq.setVisible(true);
                // Take me back to the main screen if needed
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
