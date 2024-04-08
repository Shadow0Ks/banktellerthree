import java.io.FileWriter;
import java.io.IOException;

public class CSVCustomerData {
    static String file = "src\\customer_data.csv";
    public static void writeDataToCSV(String firstName, String lastName, String moneyBox, String creditScore, String customerID) {
        try (FileWriter writer = new FileWriter(file, true)) { // Append mode enabled
            StringBuilder sb = new StringBuilder();
            sb.append(firstName).append(",");
            sb.append(lastName).append(",");
            sb.append(moneyBox).append(",");
            sb.append(creditScore).append(",");
            sb.append(customerID).append("\n");

            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
