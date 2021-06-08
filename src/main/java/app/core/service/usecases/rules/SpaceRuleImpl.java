package app.core.service.usecases.rules;

public class SpaceRuleImpl extends RuleImpl {

    private char SPACE_CHAR = ' ';

    public void checkSpaceRule(String password) {

        if (!compareString(SPACE_CHAR, password)) this.flag = true;
    }
}
