package app.core.service.usecases.rules.factory;

import app.core.service.usecases.rules.AbstractRules.*;
import app.core.service.usecases.rules.PasswordSizeRuleImpl;
import app.core.service.usecases.rules.RepeatedCharRuleImpl;
import app.core.service.usecases.rules.Rule;
import app.core.service.usecases.rules.SpaceRuleImpl;

import java.util.ArrayList;

public interface RuleFactory {


    public void createRules();

    public ArrayList<AbstractRule> getAbstractRuleInterfaces ();

    public ArrayList<Rule> getRuleInterfaces();

    public RepeatedCharRuleImpl getRepeatedCharRule();

    public SpaceRuleImpl getSpaceRule();

    public PasswordSizeRuleImpl getPasswordSizeRuleImpl();
}
