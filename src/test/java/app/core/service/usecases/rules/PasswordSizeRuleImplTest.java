package app.core.service.usecases.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordSizeRuleImplTest {

    PasswordSizeRuleImpl passwordSizeRule;
    String STRING_SUCCESS= "123456789";
    String STRING_FAIL= "12345678";
    String STRING_FAIL_BIG = "aseT0SE9GkDwqOsO5ywrO90Mbd9mSSQTSTu24GCR3hHSP7X4TGIsJPunAxgicEHdG8bqGulr7jDLCHomHjkb8kXs5I8fhxoAw1GwC8RWynsHeCqRICtJ46IFzbW32YARrttTI6wu4ttdgR8FyObfPLv6WHPHpqD9zK7XbvD7dWfuTFBCQxi1D6CAzFqPVr0tbmSDn9Z1KIaCx7DBs02N3nw4ZfnZEaRQESWDHDbqevTebTs3YZuLY8rKFaUD0kl8l";
    String STRING_SUCCESS_BIG = "eT0SE9GkDwqOsO5ywrO90Mbd9mSSQTSTu24GCR3hHSP7X4TGIsJPunAxgicEHdG8bqGulr7jDLCHomHjkb8kXs5I8fhxoAw1GwC8RWynsHeCqRICtJ46IFzbW32YARrttTI6wu4ttdgR8FyObfPLv6WHPHpqD9zK7XbvD7dWfuTFBCQxi1D6CAzFqPVr0tbmSDn9Z1KIaCx7DBs02N3nw4ZfnZEaRQESWDHDbqevTebTs3YZuLY8rKFaUD0kl8l\n";
    @BeforeEach()
    public void setup(){
        passwordSizeRule = new PasswordSizeRuleImpl();
    }
    @Test
    public void testPasswordSize(){
        passwordSizeRule.checkPasswordSize(STRING_SUCCESS);
        assertTrue(passwordSizeRule.flag);
    }
    @Test
    public void testPasswordSizeBIG(){
        passwordSizeRule.checkPasswordSize(STRING_SUCCESS_BIG);
        assertTrue(passwordSizeRule.flag);
    }
    @Test
    public void testPasswordSizeFAIL(){
        passwordSizeRule.checkPasswordSize(STRING_FAIL);
        assertFalse(passwordSizeRule.flag);
    }
    @Test
    public void testPasswordSizeFAILBIG(){
        passwordSizeRule.checkPasswordSize(STRING_FAIL_BIG);
        assertFalse(passwordSizeRule.flag);
    }


}