import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AnimationWorkingScreen extends JFrame {

    public static int SCREEN_WIDTH = 800;
    public static int SCREEN_HEIGHT = 600;

    private JTextArea textArea;

    private ScreenButtons screenButtons;

    public AnimationWorkingScreen(){

        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Bank Teller - Working man Screen");
        //setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

//        screenButtons = new ScreenButtons();
//        screenButtons.ToNextMonth(this);


        //loads the gif
        ImageIcon icon = new ImageIcon("src\\working_man.gif");
        //resizes the gif


        Image scaledImage = icon.getImage().getScaledInstance(SCREEN_WIDTH,SCREEN_HEIGHT, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel label = new JLabel(scaledIcon);
        panel.add(label, BorderLayout.CENTER);
        add(panel);


        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3 && e.getClickCount() == 2) {
                    dispose();
                    CustomerIDSearch customerIDSearch = new CustomerIDSearch();
                    customerIDSearch.setVisible(true);
                }
            }
        });

        setVisible(true);

    }



}
