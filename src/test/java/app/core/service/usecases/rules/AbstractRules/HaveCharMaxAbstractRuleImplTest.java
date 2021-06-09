package app.core.service.usecases.rules.AbstractRules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HaveCharMaxAbstractRuleImplTest {

    HaveCharMaxAbstractRuleImpl haveCharMaxAbstractRule = new HaveCharMaxAbstractRuleImpl();
    char CAPITAL_LETTER = 'P';
    char NOT_CAPITAL_LETTER = 'p';
    @Test
    public void validateRuleTest(){
        assertTrue(haveCharMaxAbstractRule.validateRule(CAPITAL_LETTER));
        assertFalse(haveCharMaxAbstractRule.validateRule(NOT_CAPITAL_LETTER));
    }

    @Test
    public void checkFlag(){
        assertFalse(haveCharMaxAbstractRule.getFlag());
    }

}