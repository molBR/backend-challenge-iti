package app.core.service.usecases.rules.AbstractRules;

import app.core.service.usecases.rules.RuleImpl;

public class HaveCharMaxAbstractRuleImpl extends RuleImpl implements AbstractRule {

    private final String lettersMax = "ABCDEFGHIJKLMNOPQRSTUVWYZ";

    @Override
    public boolean getFlag () {
        return this.flag;
    }

    @Override
    public boolean validateRule(char p){
        this.flag = this.compareString(p, lettersMax);
        return this.flag;
    }


}
