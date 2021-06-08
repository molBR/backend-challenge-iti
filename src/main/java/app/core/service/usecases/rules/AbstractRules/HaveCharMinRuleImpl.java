package app.core.service.usecases.rules.AbstractRules;

import app.core.service.usecases.rules.Rule;

public class HaveCharMinRuleImpl extends Rule implements RuleInterface {

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
