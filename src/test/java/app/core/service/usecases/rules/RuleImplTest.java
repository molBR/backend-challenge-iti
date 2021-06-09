package app.core.service.usecases.rules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RuleImplTest {

    private RuleImpl ruleImpl = new RuleImpl();
    private String STRING_TEST  = "abc";
    private char CONTAINS_CHAR = 'a';
    private char NOT_CONTAINS_CHAR = 'd';

    @Test
    public void checkCompareStringTrue(){
        assertTrue(ruleImpl.compareString(CONTAINS_CHAR, STRING_TEST));
    }

    @Test
    public void checkCompareStringFalse(){
        assertFalse(ruleImpl.compareString(NOT_CONTAINS_CHAR, STRING_TEST));
    }

}