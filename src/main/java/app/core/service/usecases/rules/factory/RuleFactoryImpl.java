package app.core.service.usecases.rules.factory;


import app.core.service.usecases.rules.AbstractRules.*;
import app.core.service.usecases.rules.PasswordSizeRuleImpl;
import app.core.service.usecases.rules.RepeatedCharRuleImpl;
import app.core.service.usecases.rules.Rule;
import app.core.service.usecases.rules.SpaceRuleImpl;

import java.util.ArrayList;

public class RuleFactoryImpl implements RuleFactory {

    private final ArrayList<AbstractRule> abstractRuleInterfaces = new ArrayList<AbstractRule>();
    private final ArrayList<Rule> ruleInterfaces = new ArrayList<Rule>();
    private RepeatedCharRuleImpl repeatedCharRule;
    private SpaceRuleImpl spaceRule;
    private PasswordSizeRuleImpl passwordSizeRule;
    private HaveCharMaxAbstractRuleImpl haveCharMaxAbstractRule;
    private HaveCharMinAbstractRuleImpl haveCharMinAbstractRule;
    private HaveDigitsAbstractRuleImpl haveDigitsAbstractRule;
    private HaveSpecialCharAbstractRuleImpl haveSpecialCharAbstractRule;


    public void createRules(){

        abstractRuleInterfaces.clear();
        ruleInterfaces.clear();

        //instanciate rules

        //singular rules
        repeatedCharRule = new RepeatedCharRuleImpl();
        spaceRule = new SpaceRuleImpl();
        passwordSizeRule = new PasswordSizeRuleImpl();

        //abstract rules
        haveCharMaxAbstractRule = new HaveCharMaxAbstractRuleImpl();
        haveCharMinAbstractRule = new HaveCharMinAbstractRuleImpl();
        haveDigitsAbstractRule = new HaveDigitsAbstractRuleImpl();
        haveSpecialCharAbstractRule = new HaveSpecialCharAbstractRuleImpl();

        //add abstract rules to specific interface array
        abstractRuleInterfaces.add(haveCharMaxAbstractRule);
        abstractRuleInterfaces.add(haveCharMinAbstractRule);
        abstractRuleInterfaces.add(haveDigitsAbstractRule);
        abstractRuleInterfaces.add(haveSpecialCharAbstractRule);

        //add all rules to specific interface array
        ruleInterfaces.add(repeatedCharRule);
        ruleInterfaces.add(spaceRule);
        ruleInterfaces.add(passwordSizeRule);
        ruleInterfaces.add(haveCharMaxAbstractRule);
        ruleInterfaces.add(haveCharMinAbstractRule);
        ruleInterfaces.add(haveDigitsAbstractRule);
        ruleInterfaces.add((haveSpecialCharAbstractRule));
    }

    @Override
    public ArrayList<AbstractRule> getAbstractRuleInterfaces () {
        return abstractRuleInterfaces;
    }

    @Override
    public  ArrayList<Rule> getRuleInterfaces() {return ruleInterfaces;}

    @Override
    public RepeatedCharRuleImpl getRepeatedCharRule() {
        return repeatedCharRule;
    }

    @Override
    public SpaceRuleImpl getSpaceRule() {return spaceRule;}

    @Override
    public PasswordSizeRuleImpl getPasswordSizeRuleImpl() {return passwordSizeRule;};
}
