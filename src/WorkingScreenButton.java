import javax.swing.*;
import java.awt.*;

public class WorkingScreenButton  extends JFrame {

    public static int SCREEN_WIDTH = 800;
    public static int SCREEN_HEIGHT = 600;

    private ScreenButtons screenButtons;

    static int DepositAmount;

    private Font font;
    public WorkingScreenButton(){
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Bank  - Deposit");
        setLocationRelativeTo(null);
        setVisible(true);

        setLayout(null);


        new AnimationWorkingScreen();


    }
}
