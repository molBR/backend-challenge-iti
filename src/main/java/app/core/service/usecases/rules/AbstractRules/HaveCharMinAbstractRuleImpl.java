package app.core.service.usecases.rules.AbstractRules;

import app.core.service.usecases.rules.RuleImpl;

public class HaveCharMinAbstractRuleImpl extends RuleImpl implements AbstractRule {

    private final String lettersMin = "abcdefghijklmnopqrstuvwxyz";

    public HaveCharMinAbstractRuleImpl(){
        this.error = "Should have minimized letters";
    }

    @Override
    public boolean getFlag () {
        return this.flag;
    }

    @Override
    public boolean validateRule(char p) {

        this.flag = this.compareString(p, lettersMin);
        return this.flag;
    }
}
