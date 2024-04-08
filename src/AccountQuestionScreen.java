import javax.swing.*;
import java.awt.*;

public class AccountQuestionScreen extends JFrame {
    public static int SCREEN_WIDTH = 800;
    public static int SCREEN_HEIGHT = 600;
    private ScreenButtons screenButtons;

    static final private Font mainFont = new Font("Segeo Print", Font.BOLD, 18);
    private JLabel pageQuestion;



    public AccountQuestionScreen(){

        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Bank Teller - Account Question Screen");
        setLocationRelativeTo(null);
        setVisible(true);

        setLayout(null);



        screenButtons = new ScreenButtons();
        screenButtons.accountDoesExistButton(this);
        screenButtons.accountDoesNotExistButton(this);

    }

    public void displayScreenQuestion(Graphics graphics){
        paintComponents(graphics);
        graphics.setFont(mainFont);
        graphics.setColor(Color.BLACK);


        String pageQuestion = "Do you have an account with us?";

        int x = (getWidth() - graphics.getFontMetrics().stringWidth(pageQuestion)) / 2;


        //positive is top of the screen
        //negative toward the bottom of the screen
        int y = getHeight() / 5;

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
        displayScreenQuestion(graphics);

    }

    public void paint(Graphics graphics){
        super.paint(graphics);
        drawRectangles(graphics);
    }






}
