package test.Encryption;

import java.io.*;
import java.util.*;
import static java.lang.System.*;
/**
 * @author Tim Ortin
 * @version 1.0
 *
 * Driver class that contains all code. When I tried running the program with separate methods
 * in different classes, it wouldn't work. So I kept everything in the main class to show functionality.
 *
 * Takes in user input as a string, encrypts the string, saves to file 1, prints to console,  reads file 1 back in,
 * decrypts the message, saves decrypted message to file 2, reads in file 2 and prints it to console.
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {

        /* initialize Scanner for user input */
        Scanner keyboard = new Scanner(in);

        /* VARIABLES */
        String string1;
        String encodedMessage = "";
        String decodedMessage = "";
        String fileString ="";
        char encodedLetter;
        char decodedLetter;
        int asciiChange;
        ArrayList<String> encodedString = new ArrayList<String>();
        ArrayList<String> decodedString = new ArrayList<String>();
        String printEncodedMessage = encodedString.toString().trim().replace(",", "")
                .replace("[", "").replace("]", "");
        String printDecodedMessage = decodedString.toString().trim().replace(",", "")
                .replace("[", "").replace("]", "");

        /* Creates files */
        File encryptingFile = new File("encrypting.txt");
        PrintWriter encryption = new PrintWriter("encrypting.txt");
        File decryptingFile = new File("decrypting.txt");
        PrintWriter decryption = new PrintWriter("decrypting.txt");

        /* user input of what text is to be written to file and encrypted */
        System.out.println("Enter Original Message For the File:");
        string1 = keyboard.nextLine();


        /* "method" that takes the user input and changes the ascii values to encrypt. */
        for (int i = 0; i <= string1.length() - 1; i++) {
            encodedLetter = string1.charAt(i);
            asciiChange = 10;
            encodedLetter += asciiChange;
            encodedMessage += encodedLetter;
        }

        /* adds encrypted message to arrayList */
        encodedString.add(encodedMessage);
        /* writes the encrypted to the first file */
        encryption.println(encodedMessage);
        /* closes file */
        encryption.close();
        /* another Scanner object created to read in the first file */
        Scanner readEncryptionFile = new Scanner(encryptingFile);
        System.out.println("ENCRYPTED FILE\n------------------");

        /* reads in data from first file and places data into String variable */
        while (readEncryptionFile.hasNext()) {
             fileString = readEncryptionFile.nextLine();
            System.out.println(fileString);
        }


        /* "method" that takes the data from file 1 and decodes it, adding back the ascii values. */
        for (int i = 0; i < fileString.length(); i++) {
            //asciiValue = 0;
            decodedLetter = encodedMessage.charAt(i);
            //asciiValue = (int) decodedLetter;
            asciiChange = 10;
            decodedLetter -= asciiChange;
            decodedMessage += decodedLetter;

        }

        /* places decoded message into the decoded ArrayList */
        decodedString.add(decodedMessage);
        /* prints the message to second file */
        decryption.println(decodedMessage.toString());
        /* closes second file */
        decryption.close();

        /* Scanner object to read the second file */
        Scanner readDecryptionFile = new Scanner(decryptingFile);
        System.out.println("\n\nDECRYPTED FILE\n------------");

        /* reads in data from second file and writes data to console */
        while (readDecryptionFile.hasNext()) {
            String decryptionFileString = readDecryptionFile.nextLine();
            System.out.println(decryptionFileString);
        }


    }
}



