import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class RiddleScreen extends JFrame {
    public static int SCREEN_WIDTH = 1000;
    public static int SCREEN_HEIGHT = 800;
    private JTextArea textArea;
    private ScreenButtons screenButtons;
    private String[] stories;

    public RiddleScreen(){
        setTitle("Bank Teller - Riddle Me this");
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);

       screenRiddleContent();




    }

    public void screenRiddleContent(){
        textArea = new JTextArea();
        textArea.setText("Black. Pure darkness. Painted over everything.\n" +
                "Words. Scattered here and there across the blackness.\n" +
                "Kind words. Difficult words. Amorous words. All sparkling\n" +
                "in the dark like jewels.\n" +
                "The words were few now. But time was shorter.\n" +
                "Grabbing the words in desperation, the tree turned to the\n" +
                "sky.\n" +
                "\n" +
                "This is wrong, whispered the tree in the voice of wind\n" +
                "through the leaves. This is not how it was supposed to be.\n" +
                "...The plan has failed.\n" +
                "\n" +
                "Once, long ago, the tree had remembered everything about\n" +
                "the world. This was its task. Its purpose.\n" +
                "It shivered with something approaching joy as it collected\n" +
                "the memories of mankind. This was no accident; emotions\n" +
                "were as much a part of the tree as root and bark.\n" +
                "Memories collected like dew on the thick green leaves of the\n" +
                "tree.\n" +
                "And once they had formed a web that spanned the entire\n" +
                "world.\n" +
                "\n" +
                "Words collapsed into sunlight before passing through the\n" +
                "leaves and into the pool of memory. From the pool, the\n" +
                "words joined together to form colonies, the colonies united\n" +
                "into whirlpools of light, and the light coalesced into stars.\n" +
                "Each star was like a child of the tree, and it loved them all.");

        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setForeground(Color.WHITE); // Set text color to white
        textArea.setBackground(Color.BLACK);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(50, 50, SCREEN_WIDTH - 100, SCREEN_HEIGHT - 100);
        add(scrollPane);

        // Add MouseListener to JTextArea
        textArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3 && e.getClickCount() == 2) {
                    storyOne();
                }
            }
        });
    }

    private void storyOne() {

        //textArea = new JTextArea();
            textArea.setText("Look at my memory.\n" +
                    "A child is here, brought low by disease. He is far too young\n" +
                    "to have suffered so.\n" +
                    "Thin beyond words, the boy's skin is a shade paler than the\n" +
                    "bleached hospital sheets upon which he lies. His parents no\n" +
                    "longer visit him, for they cannot bear to watch him suffer.\n" +
                    "The doctors have long since surrendered his fate to the\n" +
                    "gods.\n" +
                    "\n" +
                    "The boy, too, has abandoned hope. Strange emotions—\n" +
                    "weariness, hatred—swell within the dark recesses of his\n" +
                    "young heart. He tries to reject the black terror that\n" +
                    "germinates in his body, but no amount of effort or tears can\n" +
                    "drive the invader away.\n" +
                    "He has long ceased to resent his parents and doctors. Once\n" +
                    "he did, but now his pain is so great that there is little room\n" +
                    "in his heart to think of others.\n" +
                    "\n" +
                    "Only one person brings the boy comfort: a healthy young\n" +

                    //make this line dynamic
                    "girl with tan skin and deep brown eyes.\n" +


                    "\n" +
                    "She is a beacon of brightness and light in the boy's world;\n" +
                    "her very presence is a comfort to him.\n" +
                    "But he is unable to look upon her face.\n" +
                    "Whenever they meet, the boy is filled with loathing for his\n" +
                    "own state. Soon, this loathing eats away at what joy he\n" +
                    "receives from the girl's visits.\n" +
                    "The girl will stop coming. He knows this. His every waking\n" +
                    "moment is spent in fear of this day.\n" +
                    "\n" +
                    "He thinks that if he could talk to her, if he could tell her of\n" +
                    "his feelings, that this might not be so. But this conversation\n" +
                    "never happens.\n" +
                    "\n" +
                    "The girl disappears.\n" +
                    "The boy dies alone.\n" +
                    "The tree scoops up this memory and carefully stores it\n" +
                    "within itself. Etched upon it is a single word: Envy.");

        textArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3 && e.getClickCount() == 2) {
                    //this will display which question screen

                }
            }
        });

    }




    private void displayStory(int index) {
        textArea.setText(stories[index]);
    }





    private String getColorName(Color color) {
        if (color.equals(Color.GREEN))
            return "green";
        else if (color.equals(Color.BLUE))
            return "blue";
        else if (color.equals(new Color(139, 69, 19)))
            return "brown";
        else
            return "unknown";
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RiddleScreen().setVisible(true);
        });
    }

}

