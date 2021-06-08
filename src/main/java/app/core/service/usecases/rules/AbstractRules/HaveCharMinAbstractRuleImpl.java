package app.core.service.usecases.rules.AbstractRules;

import app.core.service.usecases.rules.RuleImpl;

public class HaveCharMinAbstractRuleImpl extends RuleImpl implements AbstractRule {

    private final String lettersMin = "abcdefghijklmnopqrstuvwxyz";


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
