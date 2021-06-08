package app.core.service.usecases.rules.AbstractRules;

import app.core.service.usecases.rules.RuleImpl;

public class HaveSpecialCharAbstractRuleImpl extends RuleImpl implements AbstractRule {

    private final String specialChar = "!@#$%^&*()-+";

    @Override
    public boolean getFlag () {
        return this.flag;
    }

    @Override
    public boolean validateRule(char p) {
        this.flag =this.compareString(p, specialChar);
        return this.getFlag();
    }
}
