package app.core.service.usecases;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HandleErrorsUseCase {


    public List<String> handleErrorsToList(ValidatePasswordUseCase validatePasswordUseCase){
        List<String> listOfErrors = new ArrayList<String>();

        if(!validatePasswordUseCase.getHaveCharMax()){
            listOfErrors.add("Don't have capital letters");
        }
        if(!validatePasswordUseCase.getHaveCharMin()){
            listOfErrors.add("Don't have min letters");
        }
        if(!validatePasswordUseCase.getHaveDigits()) {
            listOfErrors.add("Don't have digits");
        }
        if(!validatePasswordUseCase.getHaveSpecialChar()){
            listOfErrors.add("Don't have special characters");
        }
        if(!validatePasswordUseCase.getHaveSize()){
            listOfErrors.add("Not in right size, should be between 9 and 256");
        }
        if(!validatePasswordUseCase.getHaveSpaces()){
            listOfErrors.add("Should not have spaces");
        }
        if(!validatePasswordUseCase.getRepeatedChar()){
            listOfErrors.add("Should not have repeated char");
        }
        return listOfErrors;
    }
}
