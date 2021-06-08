package app.core.service.usecases.rules.AbstractRules;

import app.core.service.usecases.rules.AbstractRules.*;
import app.core.service.usecases.rules.RepeatedCharRule;

import java.util.ArrayList;

public class RuleFactory {

    private ArrayList<RuleInterface> ruleInterfaces = new ArrayList<RuleInterface>();
    private RepeatedCharRule repeatedCharRule = new RepeatedCharRule();

    public RuleFactory(){

        ruleInterfaces.add(new HaveCharMaxRuleImpl());
        ruleInterfaces.add(new HaveCharMinRuleImpl());
        ruleInterfaces.add(new HaveDigitsRuleImpl());
        ruleInterfaces.add(new HaveSpecialCharRuleImpl());
    }


    public ArrayList<RuleInterface> getRuleInterfaces () {
        return ruleInterfaces;
    }

    public RepeatedCharRule getRepeatedCharRule() {
        return repeatedCharRule;
    }
}
