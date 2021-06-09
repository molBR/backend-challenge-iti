package app.core.service.usecases.rules.AbstractRules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HaveCharMinAbstractRuleImplTest {

    HaveCharMinAbstractRuleImpl haveCharMinAbstractRule = new HaveCharMinAbstractRuleImpl();
    char CAPITAL_LETTER = 'P';
    char NOT_CAPITAL_LETTER = 'p';
    @Test
    public void validateRuleTest(){
        assertFalse(haveCharMinAbstractRule.validateRule(CAPITAL_LETTER));
        assertTrue(haveCharMinAbstractRule.validateRule(NOT_CAPITAL_LETTER));
    }

    @Test
    public void checkFlag(){
        assertFalse(haveCharMinAbstractRule.getFlag());
    }
}