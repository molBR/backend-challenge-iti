package app.core.service.usecases;

import app.core.service.usecases.rules.factory.RuleFactoryImpl;
import org.springframework.stereotype.Component;

@Component
public class ValidatePasswordUseCase {



    char space = ' ';


    private RuleFactoryImpl ruleFactoryImpl = new RuleFactoryImpl();;


    public boolean IsValid (String password){

        ruleFactoryImpl.createRules();

        ruleFactoryImpl.getSpaceRule().checkSpaceRule(password);

        ruleFactoryImpl.getPasswordSizeRuleImpl().checkPasswordSize(password);
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            ruleFactoryImpl.getAbstractRuleInterfaces().forEach(r ->{
                if(!r.getFlag()){
                    r.validateRule(c);
                }
            });
            if(ruleFactoryImpl.getRepeatedCharRule().getFlag())
                ruleFactoryImpl.getRepeatedCharRule().checkRepeatedChar(c, password, i);
        }

        return ruleFactoryImpl.getRuleInterfaces().stream().allMatch(val -> val.getFlag());
    }

    public RuleFactoryImpl getRuleFactoryImpl() {
        return ruleFactoryImpl;
    }
}
