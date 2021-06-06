package app.adapters.in;

import app.adapters.in.dto.PasswordRequest;
import app.adapters.in.dto.PasswordResponse;
import app.core.exceptions.BuisnessException;
import app.core.service.ValidatePasswordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class HttpController {

    @Autowired
    private ValidatePasswordServiceImpl validatePasswordServiceImpl;

    public HttpController(ValidatePasswordServiceImpl validatePasswordServiceImpl){
        this.validatePasswordServiceImpl = validatePasswordServiceImpl;
    }

    @RequestMapping(value = "/validate/password", method =  RequestMethod.POST)
    public ResponseEntity<PasswordResponse> ValidatePasswordPost(@Valid @RequestBody PasswordRequest password) throws BuisnessException {
        boolean responseIsValid = validatePasswordServiceImpl.validatePasswordService(password.getPassword());
        PasswordResponse passwordResponse = new PasswordResponse(responseIsValid, password.getPassword());
        return new ResponseEntity<PasswordResponse>(passwordResponse, new HttpHeaders(), HttpStatus.OK);
    }
}
