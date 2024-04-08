import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoanScreen extends JFrame{

    public static int SCREEN_WIDTH = 800;
    public static int SCREEN_HEIGHT = 600;
    /*-------------------------------------------------------------------------------------------------------*/

    static JTextField JTextMonthlyIncome;
    private ScreenButtons screenButtons;


    private Font font;


    ///////////////////////////////

    public LoanScreen(){


        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Bank Teller - Loan");
        setLocationRelativeTo(null);
        setVisible(true);

        setLayout(null);

        JTextMonthlyIncome = new JTextField();
        add(JTextMonthlyIncome);



        ///////////////////////////////////////////////////////////////////////
        //adding button that calculates intrest
        JButton calculateButton = new JButton("Calculate Interest");
        calculateButton.setBounds(100, 100, 200, 30);
        add(calculateButton);
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double monthlyIncome = Double.parseDouble(JTextMonthlyIncome.getText());
                int creditScore = CustomerIDSearch.creditScore; // Access credit score directly
                double interestRate = LoanCalculations.calculateLoanInterest(5.0, creditScore, monthlyIncome);
                JOptionPane.showMessageDialog(null, "Calculated interest rate: " + interestRate + "%");

            }
        });
    }

    public void LoanScreenContent(Graphics graphics){
        font = new Font("Arial", Font.BOLD, calculateFontSize() + 4);
        paintComponents(graphics);
        graphics.setFont(font);
        graphics.setColor(Color.BLACK);

        String monthlyIncomeMessage = "Please Enter your monthly Income?";
        int x = (getWidth() - graphics.getFontMetrics().stringWidth(monthlyIncomeMessage)) / 2;
        int y = getHeight() / 2;
        //display the text on the screen
        graphics.drawString(monthlyIncomeMessage, x - 200, 50);



        //make monthly income textBox
        JTextMonthlyIncome.setBounds(100, 60, 200, 30);

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
    void drawRectangles(Graphics graphics){
        //x,y location of the rectangle
        //w,h size of it
        int rectWidth = 100;
        int rectHeight  = 50;
        int rectX = (SCREEN_WIDTH - rectWidth) / 2;
        int rectY = (SCREEN_HEIGHT - rectHeight) / 2;

        graphics.setColor(Color.BLACK);
        graphics.drawRect(rectX, rectY, rectWidth,rectHeight);
        LoanScreenContent(graphics);

    }
}
