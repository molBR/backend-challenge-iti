package app.core.service.usecases;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HandleErrorsUseCase {


    public List<String> handleErrorsToList(ValidatePasswordUseCase validatePasswordUseCase){
        List<String> listOfErrors = new ArrayList<String>();


        return listOfErrors;
    }
}
