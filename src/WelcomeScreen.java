import javax.swing.*;
import java.awt.*;

public class WelcomeScreen extends JFrame {

    public static int SCREEN_WIDTH = 800;
    public static int SCREEN_HEIGHT = 600;
    Sound sound = new Sound();
    /*-------------------------------------------------------------------------------------------------------*/

    private ScreenButtons screenButtons;

    final private Font getCustomFont = FontLoader.loadFont("src\\minecraft.ttf", Font.PLAIN, 20);

    //makes the screen display
    public WelcomeScreen(){
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Bank Teller");
        setLocationRelativeTo(null);
        setVisible(true);

        setLayout(null);


        //added nextScreen Button here
        sound.setFile(2);
        sound.play();



        screenButtons = new ScreenButtons();
        screenButtons.setNextPage(this);

    }


    //gives the location to draw the content on the screen
    void drawRectangles(Graphics graphics){
        //x,y location of the rectangle
        //w,h size of it
        int rectWidth = 100;
        int rectHeight  = 50;
        int rectX = (SCREEN_WIDTH - rectWidth) / 2;
        int rectY = (SCREEN_HEIGHT - rectHeight) / 2;

        graphics.setColor(Color.BLACK);
        graphics.drawRect(rectX, rectY, rectWidth,rectHeight);
        welcomeScreenContent(graphics);

    }

    //content of the welcome screen
    public void welcomeScreenContent(Graphics graphics){
        //font = new Font("Arial", Font.ITALIC, calculateFontSize());
        paintComponents(graphics);
        graphics.setFont(getCustomFont);
        graphics.setColor(Color.BLACK);

        String message = "Welcome to the Bank :3!";

        //set the location of the text
        int x = (getWidth() - graphics.getFontMetrics().stringWidth(message)) / 2;
        int y = getHeight() / 2;
        //display the text on the screen
        graphics.drawString(message, x, y);


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


}
