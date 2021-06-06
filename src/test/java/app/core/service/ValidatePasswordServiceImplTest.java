package app.core.service;

import app.core.exceptions.BuisnessException;
import app.core.service.usecases.HandleErrorsUseCase;
import app.core.service.usecases.ValidatePasswordUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ValidatePasswordServiceImplTest {


    String SUCCESS_STRING = "AbTp9!fok";
    String FAIL_STRING = "shouldfail";

    @Mock
    ValidatePasswordUseCase validatePasswordUseCase;
    @Mock
    HandleErrorsUseCase handleErrorsUseCase;

    ValidatePasswordServiceImpl validatePasswordService;

    @BeforeEach
    public void setup () {
        MockitoAnnotations.initMocks(this);
        List<String> list = new ArrayList<String>();
        list.add("testString");
        when(handleErrorsUseCase.handleErrorsToList(any())).thenReturn(list);
        validatePasswordService = new ValidatePasswordServiceImpl(validatePasswordUseCase, handleErrorsUseCase);
    }

    @Test
    public void validateServiceTrue() throws BuisnessException {

        when(validatePasswordUseCase.IsValid(any())).thenReturn(true);
        boolean result = validatePasswordService.validatePasswordService(SUCCESS_STRING);
        verify(validatePasswordUseCase).IsValid(SUCCESS_STRING);
        assertTrue(result);
    }
    @Test
    public void validateServiceFalse() throws BuisnessException {

        when(validatePasswordUseCase.IsValid(any())).thenReturn(false);
        assertThrows(BuisnessException.class, () -> {
           validatePasswordService.validatePasswordService(FAIL_STRING);
        });
        verify(validatePasswordUseCase).IsValid(FAIL_STRING);
        verify(handleErrorsUseCase).handleErrorsToList(validatePasswordUseCase);
    }


}