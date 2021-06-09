package app.core.service.usecases.rules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpaceRuleImplTest {

    SpaceRuleImpl spaceRule = new SpaceRuleImpl();
    String STRING_WITHOUT = "abcdefgh";

    @Test
    public void testSpaceRule(){

        spaceRule.checkSpaceRule(STRING_WITHOUT);
        assertTrue(spaceRule.flag);

    }

}