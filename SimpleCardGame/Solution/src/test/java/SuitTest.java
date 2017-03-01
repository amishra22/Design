import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class SuitTest {

    Suit suit;
    @Before
    public void setup(){
        suit = Suit.getSuitFromValue(0);
    }

    @Test
    public void getValue() throws Exception {
        assertEquals(0, suit.getValue());
    }

    @Test
    public void getSuitFromValue() throws Exception {
        assertEquals("Club", suit.name());
    }

}