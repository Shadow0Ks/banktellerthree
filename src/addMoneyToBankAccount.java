import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class addMoneyToBankAccount {
    private double deposit;
    static String file = "src\\customer_data.csv";

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public static void addMoneyToCustomer(){
        boolean found = false;
        String[] customerInfo = null;

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null){
                String[] data = line.split(",");
                //System.out.println();

                if (data.length > 2){
                    String moneyFromFile = data[2].trim();
                    double moneyFromFileToStore = Double.parseDouble(moneyFromFile);
                    double storeAmount = moneyFromFileToStore + 5000;
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
