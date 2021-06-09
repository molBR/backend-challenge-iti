package app.core.service.usecases.rules.factory;

import app.core.service.usecases.rules.Rule;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class RuleFactoryImplTest {

    RuleFactoryImpl ruleFactory;

    @BeforeEach
    public void setup(){
        ruleFactory = Mockito.spy(new RuleFactoryImpl());
        ruleFactory.createRules();

    }

    @Test
    public void checkArrayList(){

        verify(ruleFactory).clearRules();
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