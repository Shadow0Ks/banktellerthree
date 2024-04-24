package Animations;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationManager extends JFrame {
    //define the animation


    //increment an integer then change the number for the user

    public AnimationManager(){
        // Setting up the JFrame title
        super("GIF on Button Click");

        // Create a JButton
        JButton button = new JButton("Show GIF");

        // Create a JLabel to display the GIF
        JLabel label = new JLabel();

        // Add the JButton and JLabel to the JFrame
        getContentPane().add(button, "North");
        getContentPane().add(label, "Center");

        // Set the size of the JFrame
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // ActionListener for the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Load the GIF inside the label when the button is clicked
                label.setIcon(new ImageIcon("E:\\Sac State\\CSC 130\\Project2\\bank_Teller3\\Bank Teller Three app\\untitled\\src\\attackomo-omori.gif"));
            }
        });
    }

    public static void main(String[] args) {
        new AnimationManager(); // Run the application
    }
}
