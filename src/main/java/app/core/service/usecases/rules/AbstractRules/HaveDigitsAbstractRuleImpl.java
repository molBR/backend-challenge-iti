package app.core.service.usecases.rules.AbstractRules;

import app.core.service.usecases.rules.RuleImpl;

public class HaveDigitsAbstractRuleImpl extends RuleImpl implements AbstractRule {
    private final String digits = "123456789";

    @Override
    public boolean getFlag () {
        return this.flag;
    }


    @Override
    public boolean validateRule(char p) {
        this.flag = this.compareString(p, digits);
        return this.flag;
    }
}
