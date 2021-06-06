package app.adapters.in.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordRequestTest {

    PasswordRequest passwordRequest = new PasswordRequest();

    @Test
    public void test(){
        String PASSWORD = "test";
        passwordRequest.setPassword(PASSWORD);
        assertEquals(PASSWORD, passwordRequest.getPassword());
    }

}