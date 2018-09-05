package test.Encryption;

import java.util.ArrayList;

/**
 * @author Tim Ortin
 * @version 1.0
 *
 * Class is not functional
 */

public class Encryption{

    private String encodedMessage;

    public Encryption(){

    }

    public void setEncodedMessage(String s, String encodedMessage){

        for (int i = 0; i <= s.length() - 1; i++) {
            //asciiValue = 0;
            char encodedLetter = s.charAt(i);
            // asciiValue = (int) encodedLetter;
            int asciiChange = 10;
            encodedLetter += asciiChange;
            encodedMessage += encodedLetter;

            this.encodedMessage = encodedMessage;
        }
    }

    public String getEncodedMessage(){
        return encodedMessage.trim().replace(",", "")
                .replace("[", "").replace("]", "");
    }
}
