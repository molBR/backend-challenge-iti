package app.core.service.usecases.rules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepeatedCharRuleImplTest {

    private String WRONG_STRING = "CC";
    private char WRONG_CHAR = 'C';
    private RepeatedCharRuleImpl repeatedCharRule = new RepeatedCharRuleImpl();

    @Test
    public void testOk(){
        repeatedCharRule.checkRepeatedChar(WRONG_CHAR, WRONG_STRING, 0);
        assertFalse(repeatedCharRule.flag);
    }

}