package app.core.service.usecases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatePasswordRequestUseCaseTest {

    private ValidatePasswordUseCase validatePasswordService = new ValidatePasswordUseCase();

    @Test
    public void shouldBeFalse() {


        assertFalse(validatePasswordService.IsValid(""));
        assertFalse(validatePasswordService.IsValid("aa"));
        assertFalse(validatePasswordService.IsValid("ab"));
        assertFalse(validatePasswordService.IsValid("AAAbbbCc"));
        assertFalse(validatePasswordService.IsValid("AbTp9!foo"));
        assertFalse(validatePasswordService.IsValid("AbTp9!foA"));
        assertFalse(validatePasswordService.IsValid("AbTp9 fok"));

    }
    @Test
    public void shouldBeTrue() {
        assertTrue(validatePasswordService.IsValid("AbTp9!fok"));
    }

}