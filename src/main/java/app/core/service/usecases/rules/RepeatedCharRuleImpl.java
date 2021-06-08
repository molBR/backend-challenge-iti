package app.core.service.usecases.rules;

public class RepeatedCharRuleImpl extends RuleImpl {

    public RepeatedCharRuleImpl(){
        this.flag = true;
    }
    public void checkRepeatedChar(char c, String password, int i){
        String result = password.substring(0, i) + password.substring(i+1); //return char from index.
        if(this.compareString(c, result)) this.flag = false;
    }
}
