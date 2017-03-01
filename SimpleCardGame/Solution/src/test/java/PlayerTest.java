import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class PlayerTest {

    List<Card> inPlayDeck;
    Player p1;
    Card c1,c2;

    @Before
    public void setup(){
        c1 = new Card(5,Suit.Club);
        inPlayDeck = new ArrayList<>();
        inPlayDeck.add(c1);
        p1 = new Player("TestPlayer", inPlayDeck);
        c2 = new Card(7,Suit.Diamond);
        p1.addToReserveDeck(c2);

    }

    @Test
    public void getName() throws Exception {
        assertTrue(p1.getName().equals("TestPlayer"));
    }

    @Test
    public void dealCardPlayDeckNotEmpty() throws Exception {
        assertEquals(c1, p1.dealCard());
    }

    @Test
    public void dealCardPlayDeckEmptyReserveDeckNotEmpty() throws Exception {
        p1.dealCard();
        assertEquals(c2, p1.dealCard());
    }

    @Test
    public void dealCardPlayDeckEmptyReserveDeckEmpty() throws Exception {
        p1.dealCard();
        p1.dealCard();
        assertNull(p1.dealCard());
    }

    @Test
    public void addToReserveDeck() throws Exception {
        p1.dealCard();
        p1.dealCard();
        assertNull(p1.dealCard());
        Card c3 = new Card(8,Suit.Club);
        p1.addToReserveDeck(c3);
        assertEquals(c3, p1.dealCard());
    }

    @Test
    public void addToReserveDeckAsList() throws Exception {
        p1.dealCard();
        p1.dealCard();
        assertNull(p1.dealCard());
        Card c3 = new Card(8,Suit.Club);
        List<Card> cardList = new ArrayList<>();
        cardList.add(c3);
        p1.addToReserveDeck(cardList);
        assertEquals(c3, p1.dealCard());
    }

}