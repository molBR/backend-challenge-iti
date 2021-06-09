package app.core.service.usecases;

import app.core.service.usecases.rules.Rule;
import app.core.service.usecases.rules.factory.RuleFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HandleErrorsUseCase {


    public List<String> handleErrorsToList(ValidatePasswordUseCase validatePasswordUseCase){
        List<String> listOfErrors = new ArrayList<String>();
        RuleFactory ruleFactory = validatePasswordUseCase.getRuleFactoryImpl();
        ruleFactory.getRuleInterfaces().stream().forEach(rule -> {
            if(!rule.getFlag()){
                listOfErrors.add(rule.getError());
            }
        });

        return listOfErrors;
    }
}
