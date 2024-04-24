import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ScreenButtons extends JFrame implements ItemListener {
    private JButton nextPage;
    private JButton Save;
    private JButton NextPageInfoButton;
    private JButton loanButton;

    private JButton depositButton;
    private JButton yesAccountDoesExistButton;
    private JButton noAccountDoesNotExistButton;

    private JButton goingToWork;

    final private Font mainFont = new Font("Segeo Print", Font.BOLD, 18);

    int nextPageX = WelcomeScreen.SCREEN_WIDTH - 150;
    int nextPageY = WelcomeScreen.SCREEN_HEIGHT - 80;

    public void SetGoingToWorkButton(CustomerInformationScreen customerInformationScreen){
        goingToWork = new JButton("Go To Work");
        goingToWork.setBounds(nextPageX,nextPageY, 100, 30);
        add(goingToWork, BorderLayout.SOUTH);
        customerInformationScreen.add(goingToWork);

        goingToWork.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                customerInformationScreen.dispose();
                WorkingScreenButton workingScreenButton1 = new WorkingScreenButton();


            }
        });

    }

    public void setNextPage(WelcomeScreen welcomeScreen){

        nextPage = new JButton("Next Page");

        nextPage.setBounds(nextPageX ,  nextPageY,100,30);
        add(nextPage, BorderLayout.SOUTH);
        welcomeScreen.add(nextPage);

        //set event listener
        nextPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //close already Existing Window
                if (e.getSource() == nextPage) {

                    EventQueue.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            welcomeScreen.dispose();
                            AccountQuestionScreen accountQuestionScreen = new AccountQuestionScreen();
                            accountQuestionScreen.setVisible(true);
                        }
                    });
                }
            }

        });
    }

    public void NextPageSaveCustomerInfoButton(EnterCustomerInformationScreen customerInformationScreen){
        Save = new JButton("Save");
        Save.setBounds(nextPageX,nextPageY, 100, 30);
        add(Save, BorderLayout.SOUTH);
        customerInformationScreen.add(Save);
        Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Save){
                    EventQueue.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            EnterCustomerInformationScreen.saveCustomerInfo();
                            customerInformationScreen.dispose();
                            AccountQuestionScreen accountQuestionScreen = new AccountQuestionScreen();
                            accountQuestionScreen.setVisible(true);
                        }
                    });
                }
            }
        });

    }
    public void accountDoesExistButton(AccountQuestionScreen accountQuestionScreen){

        int buttonWidth = 200;
        int buttonHeight = 50;
        int buttonX = (nextPageX - buttonWidth) - 2;
        int buttonY = (nextPageY - buttonHeight) - 2;


        yesAccountDoesExistButton = new JButton("Yes, I do have an Account");
        yesAccountDoesExistButton.setBounds(buttonX, buttonY, 300, 30);
        add(yesAccountDoesExistButton, BorderLayout.EAST);
        accountQuestionScreen.add(yesAccountDoesExistButton);

        yesAccountDoesExistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == yesAccountDoesExistButton){
                    EventQueue.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            accountQuestionScreen.dispose();

                            //set the next screen after that

                            CustomerIDSearch customerIDSearch = new CustomerIDSearch();
                            customerIDSearch.setVisible(true);

                        }
                    });
                }
            }
        });

    }

    public void accountDoesNotExistButton(AccountQuestionScreen accountQuestionScreen){
        int buttonWidth = 200;
        int buttonHeight = 50;
        int buttonX =  2;
        int buttonY = (nextPageY - buttonHeight) - 2;

        noAccountDoesNotExistButton = new JButton("No, I do not have an Account");
        noAccountDoesNotExistButton.setBounds(buttonX,buttonY, 300,30);
        add(noAccountDoesNotExistButton,BorderLayout.WEST);
        accountQuestionScreen.add(noAccountDoesNotExistButton);

        noAccountDoesNotExistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == noAccountDoesNotExistButton){
                    EventQueue.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            accountQuestionScreen.dispose();

                            //set the next screen after that
                            EnterCustomerInformationScreen enterCustomerInformationScreen = new EnterCustomerInformationScreen();
                            enterCustomerInformationScreen.setVisible(true);
                        }
                    });
                }
            }
        });
    }
    public void ButtonThatTakesToInfoScreen(CustomerIDSearch customerIDSearch) {
        int buttonWidth = 200;
        int buttonHeight = 50;
        int buttonX = (nextPageX - buttonWidth) - 2;
        int buttonY = (nextPageY - buttonHeight) - 2;

        NextPageInfoButton = new JButton("Your Bank Information");
        NextPageInfoButton.setBounds(buttonX, buttonY, 300, 30);
        add(NextPageInfoButton, BorderLayout.EAST);
        customerIDSearch.add(NextPageInfoButton);

        NextPageInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == NextPageInfoButton){
                    EventQueue.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            CustomerIDSearch.checkCustomerID();
                            customerIDSearch.dispose();
                        }
                    });
                }
            }
        });
    }

    public void ButtonThatTakesBackToWelcomeScreen(LoanScreen welcomeScreen){
        int buttonWidth = 200;
        int buttonHeight = 50;
        int buttonX = (nextPageX - buttonWidth) - 2;
        int buttonY = (nextPageY - buttonHeight) - 2;

        nextPage = new JButton("Main Screen");
        nextPage.setBounds(buttonX,buttonY,300,30);
        add(nextPage,BorderLayout.SOUTH);
        welcomeScreen.add(nextPage);

        nextPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == nextPage){
                    EventQueue.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            welcomeScreen.dispose();


                            AccountQuestionScreen accountQuestionScreen = new AccountQuestionScreen();
                            accountQuestionScreen.setVisible(true);
                        }
                    });
                }
            }
        });
    }

    public void TakeOutLoanButton(CustomerInformationScreen customerInformationScreen){
        setLayout(null);
        int buttonWidth = 200;
        int buttonHeight = 50;
        int buttonX = (nextPageX - buttonWidth) - 2;
        int buttonY = (nextPageY - buttonHeight) - 2;

        loanButton = new JButton("Take out loan");
        loanButton.setBounds(buttonX,buttonY,300,30);
        //add(loanButton,BorderLayout.SOUTH);
        customerInformationScreen.add(loanButton);

        loanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == loanButton){
                    EventQueue.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            customerInformationScreen.dispose();
                            LoanScreen loanScreen = new LoanScreen();
                        }
                    });
                }
            }
        });
    }
    public void DepositMoneyButton(CustomerInformationScreen customerInformationScreen){
        setLayout(null);
        int buttonWidth = 200;
        int buttonHeight = 100;
        int buttonX = (nextPageX - buttonWidth) - 2;
        int buttonY = (nextPageY - buttonHeight) - 2;

        depositButton = new JButton("Deposit Money");
        depositButton.setBounds(buttonX,buttonY,300,30);
        customerInformationScreen.add(depositButton);

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == depositButton){
                    EventQueue.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            customerInformationScreen.dispose();
                            DepositScreen depositScreen = new DepositScreen();
                        }
                    });
                }
            }
        });
    }



    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}
