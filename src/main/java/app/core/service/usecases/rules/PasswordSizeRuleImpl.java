package app.core.service.usecases.rules;

import app.core.service.usecases.rules.RuleImpl;

public class PasswordSizeRuleImpl extends RuleImpl {

    public PasswordSizeRuleImpl(){
        this.error = "Not in the right size, should be greater than 9 and smaller than 256 char";
    }

    public void checkPasswordSize(String password){
        int size = password.length();
        if(!(size < 9 || size > 256)) {
            this.flag = true;
        }
    }
}
