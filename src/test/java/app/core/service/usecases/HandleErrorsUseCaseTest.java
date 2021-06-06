package app.core.service.usecases;

import app.core.service.ValidatePasswordServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HandleErrorsUseCaseTest {

    HandleErrorsUseCase handleErrorsUseCase = new HandleErrorsUseCase();
    ValidatePasswordUseCase validatePasswordUseCase = new ValidatePasswordUseCase();



    @Test
    public void handleTests1() {
        List<String> compareList = new ArrayList<>();
        validatePasswordUseCase.IsValid(" ");
        compareList.add("Don't have capital letters");
        compareList.add("Don't have min letters");
        compareList.add("Don't have digits");
        compareList.add("Don't have special characters");
        compareList.add("Not in right size, should be between 9 and 256");
        compareList.add("Should not have spaces");
        List<String> list = handleErrorsUseCase.handleErrorsToList(validatePasswordUseCase);
        assertEquals(compareList, list);
    }

    @Test
    public void handleTests2() {
        List<String> compareList = new ArrayList<>();
        validatePasswordUseCase.IsValid("aa");
        compareList.add("Don't have capital letters");
        compareList.add("Don't have digits");
        compareList.add("Don't have special characters");
        compareList.add("Not in right size, should be between 9 and 256");
        compareList.add("Should not have repeated char");
        List<String> list = handleErrorsUseCase.handleErrorsToList(validatePasswordUseCase);
        assertEquals(compareList, list);
    }

}