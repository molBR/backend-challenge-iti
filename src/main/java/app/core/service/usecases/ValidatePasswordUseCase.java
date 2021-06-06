package app.core.service.usecases;

import org.springframework.stereotype.Component;

@Component
public class ValidatePasswordUseCase {


    private Boolean haveCharMax = false;
    private Boolean haveCharMin = false;
    private Boolean haveSpecialChar = false;
    private Boolean haveDigits = false;

    private Boolean haveSize = true;
    private Boolean haveSpace = true;

    private Boolean repeatedChar = true;

    private final String lettersMax = "ABCDEFGHIJKLMNOPQRSTUVWYZ";
    private final String lettersMin = "abcdefghijklmnopqrstuvwxyz";
    private final String specialChar = "!@#$%^&*()-+";
    private final String digits = "123456789";
    char space = ' ';



    private boolean compareString(char p, String letters) {
        return letters.indexOf(p) != -1;
    }

    public boolean IsValid (String password){

        if(compareString(space, password)) {
            haveSpace = false;
        }
        if(password.length() < 9) {
            haveSize = false;
        }
        String getCharRepeated = "";
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if(!haveCharMax) haveCharMax = compareString(c, lettersMax);
            if(!haveCharMin) haveCharMin = compareString(c, lettersMin);
            if(!haveDigits) haveDigits = compareString(c, digits);
            if(!haveSpecialChar) haveSpecialChar = compareString(c, specialChar);

            String result = password.substring(0, i) + password.substring(i+1); //return char from index.
            if(compareString(c,result)) repeatedChar = false;
        }

        return haveCharMax && haveCharMin && haveSpecialChar && haveDigits && haveSpace && haveSize && repeatedChar;
    }

    //getters
    public boolean getHaveCharMax(){
        return haveCharMax;
    }
    public boolean getHaveCharMin(){
        return haveCharMin;
    }
    public boolean getHaveSpecialChar(){
        return haveSpecialChar;
    }
    public boolean getHaveDigits(){
        return haveDigits;
    }

    public boolean getHaveSize(){
        return haveSize;
    }
    public boolean getHaveSpaces(){
        return haveSpace;
    }

    public boolean getRepeatedChar() {return repeatedChar;}



}
