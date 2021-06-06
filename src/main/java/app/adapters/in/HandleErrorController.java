package app.adapters.in;

import app.adapters.in.dto.ErrorDto;
import app.core.exceptions.BuisnessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleErrorController {

    @ExceptionHandler(value = BuisnessException.class)
    ResponseEntity<ErrorDto> handleValidPasswordError (BuisnessException buisEx) {
        ErrorDto error = new ErrorDto(buisEx.getListOfErrors(), buisEx.getMessage());
        return new ResponseEntity<ErrorDto>(error, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
