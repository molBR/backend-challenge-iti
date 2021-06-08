package app.core.service.usecases.rules;

public class Rule {

    protected boolean flag = false;

    public boolean compareString(char p, String letters){
        return letters.indexOf(p) != -1;
    }


}
