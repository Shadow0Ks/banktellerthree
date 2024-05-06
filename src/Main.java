import javax.swing.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/*
Mahmoud Alqaisi
Essam Mashal
Akhila Herath
Johnny Ly

 */
public class Main {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {

        new WelcomeScreen();
        Encryptor.encrypt();

    }
}