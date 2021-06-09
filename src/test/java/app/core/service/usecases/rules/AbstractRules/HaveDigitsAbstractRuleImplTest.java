package app.core.service.usecases.rules.AbstractRules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HaveDigitsAbstractRuleImplTest {

    HaveDigitsAbstractRuleImpl haveDigitsAbstractRule = new HaveDigitsAbstractRuleImpl();
    char DIGIT = '1';
    char NOT_DIGIT = 'p';
    @Test
    public void validateRuleTest(){
        assertTrue(haveDigitsAbstractRule.validateRule(DIGIT));
        assertFalse(haveDigitsAbstractRule.validateRule(NOT_DIGIT));
    }

    @Test
    public void checkFlag(){
        assertFalse(haveDigitsAbstractRule.getFlag());
    }

}