package app.core.service.usecases.rules;

import app.core.service.usecases.rules.RuleImpl;

public class PasswordSizeRuleImpl extends RuleImpl {

    public void checkPasswordSize(String password){
        int size = password.length();
        if(!(size < 9 || size > 256)) {
            this.flag = true;
        }
    }
}
