package app.core.service;

import app.core.exceptions.BuisnessException;
import app.core.service.usecases.HandleErrorsUseCase;
import app.core.service.usecases.ValidatePasswordUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidatePasswordServiceImpl {

    @Autowired
    private ValidatePasswordUseCase validatePasswordUseCase;
    @Autowired
    private HandleErrorsUseCase handleErrorsUseCase;

    ValidatePasswordServiceImpl(ValidatePasswordUseCase validatePasswordUseCase, HandleErrorsUseCase handleErrorsUseCase){
        this.validatePasswordUseCase = validatePasswordUseCase;
        this.handleErrorsUseCase = handleErrorsUseCase;
    }

    public boolean validatePasswordService (String password) throws BuisnessException {

        if(validatePasswordUseCase.IsValid(password)){
            return true;
        }else {
            List<String> listOfErrors = handleErrorsUseCase.handleErrorsToList(validatePasswordUseCase);
            throw new BuisnessException("Not a valid password", listOfErrors);
        }
    }

}
