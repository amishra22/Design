
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CardTest {

    Card c = new Card(7,Suit.Club);
    Card c2 = new Card(13, Suit.Diamond);

    @Test
    public void getFaceVal() throws Exception {
        assertEquals(c.getFaceVal(), 7);
    }

    @Test
    public void suit() throws Exception {
        assertEquals(c.getsuit(),Suit.Club);
    }

    @Test
    public void compareTo() throws Exception {
        assertTrue(c.compareTo(c2) < 0);

    }



}