package app.core.service.usecases.rules.AbstractRules;

import app.core.service.usecases.rules.Rule;

public class HaveDigitsRuleImpl extends Rule implements RuleInterface {
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
