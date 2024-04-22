import javax.swing.*;
import java.awt.*;

public class DepositScreen extends JFrame{
    public static int SCREEN_WIDTH = 800;
    public static int SCREEN_HEIGHT = 600;

    private Font font;
    public DepositScreen(){
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Bank Teller - Deposit");
        setLocationRelativeTo(null);
        setVisible(true);

        setLayout(null);
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
        depositScreenContent(graphics);




    }
    public void depositScreenContent(Graphics graphics){
        font = new Font("Arial", Font.ITALIC, calculateFontSize() + 2);
        paintComponents(graphics);
        graphics.setFont(font);
        graphics.setColor(Color.BLACK);

        String message = "How much would you like to deposit:";

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
