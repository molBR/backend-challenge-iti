package app.adapters.in;

import app.adapters.in.dto.ErrorDto;
import app.core.exceptions.BuisnessException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HandleErrorControllerTest {


    HandleErrorController handleErrorController = new HandleErrorController();


    @Test
    public void handleErrorTest () {
        ArrayList<String> list = new ArrayList<String>();
        list.add("error");
        BuisnessException buisnessException = new BuisnessException("Error Test", list);
        ResponseEntity<ErrorDto> errorEntity = handleErrorController.handleValidPasswordError(buisnessException);
        assertEquals(HttpStatus.BAD_REQUEST, errorEntity.getStatusCode());
    }
}