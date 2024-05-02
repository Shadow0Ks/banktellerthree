import javax.swing.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {

        new WelcomeScreen();
        Encryptor.encrypt();

    }
}