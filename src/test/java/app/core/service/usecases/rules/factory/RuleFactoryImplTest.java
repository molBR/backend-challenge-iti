package app.core.service.usecases.rules.factory;

import app.core.service.usecases.rules.Rule;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RuleFactoryImplTest {

    RuleFactoryImpl ruleFactory = new RuleFactoryImpl();

    @BeforeEach
    public void setup(){
        ruleFactory.createRules();
    }

    @Test
    public void checkArrayList(){

        assertEquals("ArrayList", ruleFactory.getRuleInterfaces().getClass().getSimpleName());
        assertEquals("ArrayList", ruleFactory.getAbstractRuleInterfaces().getClass().getSimpleName());

    }

    @Test
    public void getPasswordSize(){

        assertEquals("PasswordSizeRuleImpl", ruleFactory.getPasswordSizeRuleImpl().getClass().getSimpleName());

    }

    @Test
    public void getSpaceRule(){

        assertEquals("SpaceRuleImpl", ruleFactory.getSpaceRule().getClass().getSimpleName());

    }

    @Test
    public void repeatedCharRule(){

        assertEquals("RepeatedCharRuleImpl", ruleFactory.getRepeatedCharRule().getClass().getSimpleName());

    }

}