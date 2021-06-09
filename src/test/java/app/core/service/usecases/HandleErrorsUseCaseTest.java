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
        compareList.add("Password should not have spaces");
        compareList.add("Not in the right size, should be greater than 9 and smaller than 256 char");
        compareList.add("Should have capital letters");
        compareList.add("Should have minimized letters");
        compareList.add("Should have digits");
        compareList.add("Should have Special Characters");
        List<String> list = handleErrorsUseCase.handleErrorsToList(validatePasswordUseCase);
        assertEquals(compareList, list);
    }

    @Test
    public void handleTests2() {
        List<String> compareList = new ArrayList<String>();
        validatePasswordUseCase.IsValid("aa");
        compareList.add("Should not have repeated char");
        compareList.add("Not in the right size");
        compareList.add("should be greater than 9 and smaller than 256 char");
        compareList.add("Should have capital letters");
        compareList.add("Should have digits");
        compareList.add("Should have Special Characters");
        List<String> list = handleErrorsUseCase.handleErrorsToList(validatePasswordUseCase);
        assertEquals(compareList.get(0), list.get(0));
    }

}