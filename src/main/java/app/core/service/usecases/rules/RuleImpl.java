package app.core.service.usecases.rules;

public class RuleImpl implements Rule {

    protected boolean flag = false;
    protected String error = "";
    protected boolean compareString(char p, String letters){
        return letters.indexOf(p) != -1;
    }


    @Override
    public boolean getFlag() {
        return flag;
    }

    @Override
    public String getError(){return error;}
}
