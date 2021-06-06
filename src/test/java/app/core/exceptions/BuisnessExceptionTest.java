package app.core.exceptions;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BuisnessExceptionTest {

    @Test
    public void shouldCreateExc() {

        List<String> list = new ArrayList<String>();
        list.add("errrorTest");
        BuisnessException buisnessException = new BuisnessException("error", list);
        assertEquals(list, buisnessException.listOfErrors);

    }


}