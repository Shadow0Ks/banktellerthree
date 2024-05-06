import javax.swing.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/*
Mahmoud Alqaisi
Essam Mshal
Akhila Herath
Adrian Amador
Johnny Ly


 */
public class Main {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {

        new WelcomeScreen();
        Encryptor.encrypt();

    }
}