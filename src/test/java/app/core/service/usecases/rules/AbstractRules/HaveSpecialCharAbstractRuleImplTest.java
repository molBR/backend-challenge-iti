package app.core.service.usecases.rules.AbstractRules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HaveSpecialCharAbstractRuleImplTest {



    HaveSpecialCharAbstractRuleImpl haveSpecialCharAbstractRule = new HaveSpecialCharAbstractRuleImpl();
    char SPECIAL_CHAR = '!';
    char NOT_SPECIAL_CHAR = 'p';
    @Test
    public void validateRuleTest(){
        assertTrue(haveSpecialCharAbstractRule.validateRule(SPECIAL_CHAR));
        assertFalse(haveSpecialCharAbstractRule.validateRule(NOT_SPECIAL_CHAR));
    }

    @Test
    public void checkFlag(){
        assertFalse(haveSpecialCharAbstractRule.getFlag());
    }

}