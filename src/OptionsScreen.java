import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionsScreen extends JFrame {

    public OptionsScreen(){
        setTitle("Options");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JButton buyCarButton = new JButton("Buy a 50000$ Car");
        buyCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the screen for buying a car
                CarBuyingScreen carBuyingScreen = new CarBuyingScreen();
                carBuyingScreen.setVisible(true);
                dispose(); // Close the current screen
            }
        });

        JButton playRiddleButton = new JButton("Play a Riddle");
        playRiddleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the screen for playing a riddle
                RiddleScreen riddleScreen = new RiddleScreen();
                riddleScreen.setVisible(true);
                dispose(); // Close the current screen
            }
        });

        panel.add(buyCarButton);
        panel.add(playRiddleButton);

        add(panel);

    }
}
