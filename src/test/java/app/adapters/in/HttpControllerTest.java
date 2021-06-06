package app.adapters.in;

import app.adapters.in.dto.PasswordRequest;
import app.adapters.in.dto.PasswordResponse;
import app.core.exceptions.BuisnessException;
import app.core.service.ValidatePasswordServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class HttpControllerTest {

    String PASSWORD_TEST = "AbTp9!fok";

    @Mock
    ValidatePasswordServiceImpl validatePasswordService;

    @Mock
    PasswordRequest passwordRequest;

    HttpController httpController;

    @BeforeEach
    public void setup () throws BuisnessException {

        MockitoAnnotations.initMocks(this);
        when(passwordRequest.getPassword()).thenReturn(PASSWORD_TEST);
        when(validatePasswordService.validatePasswordService(any())).thenReturn(true);
        httpController = new HttpController(validatePasswordService);

    }

    @Test
    public void shouldWork() throws BuisnessException {
        ResponseEntity<PasswordResponse> response = httpController.ValidatePasswordPost(passwordRequest);
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }
}