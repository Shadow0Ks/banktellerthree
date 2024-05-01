import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryptor {
    public String encryptString(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(input.getBytes());
        BigInteger bigInt = new BigInteger(1, messageDigest);
        return bigInt.toString(16);
    }

    //this will be called in another method
    public static void encrypt() throws IOException, NoSuchAlgorithmException {
        Encryptor encryptor = new Encryptor();

        String csvFile = "src\\customer_data.csv";
        String line;
        String lastCustomerID = null;

        // Read the CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                // System.out.println("Read line: " + line); // Debug output
                // Split the CSV line
                String[] data = line.split(",");
                if (data.length > 4) {
                    lastCustomerID = data[4].trim(); // customerID is at index 4
                    System.out.println("Found customerID: " + lastCustomerID); // Debug output
                    String encryptedID = encryptor.encryptString(lastCustomerID);
                    System.out.println("Encrypted Customer ID: " + encryptedID);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        Encryptor encryptor = new Encryptor();

        String csvFile = "src\\customer_data.csv";
        String line;
        String lastCustomerID = null;

        // Read the CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                // System.out.println("Read line: " + line); // Debug output
                // Split the CSV line
                String[] data = line.split(",");
                if (data.length > 4) {
                    lastCustomerID = data[4].trim(); // customerID is at index 4
                    System.out.println("Found customerID: " + lastCustomerID); // Debug output
                    String encryptedID = encryptor.encryptString(lastCustomerID);
                    System.out.println("Encrypted Customer ID: " + encryptedID);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // if (lastCustomerID != null) {
        //     // Encrypt the last customerID
        //     String encryptedID = encryptor.encryptString(lastCustomerID);
        //     System.out.println("Encrypted Customer ID: " + encryptedID);
        // } else {
        //     System.out.println("No customerID found in the CSV file.");
        // }
    }
}
