import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class DeckTest {

    Deck d;
    Card c1, c2, c3, c4;

    @Before
    public void setup(){
        c1 = new Card(5,Suit.Club);
        c2 = new Card(6,Suit.Diamond);
        c3 = new Card(7,Suit.Spade);
        c4 = new Card(8,Suit.Heart);
        List<Card> cardList = new ArrayList<>();
        cardList.add(c1); cardList.add(c2); cardList.add(c3); cardList.add(c4);
        d = new Deck(cardList);
    }

    @Test
    public void dealCard() throws Exception {
        assertEquals(4, d.size());
        d.dealCard();
        assertEquals(3, d.size());
    }

    @Test
    public void addCard() throws Exception {
        assertEquals(4, d.size());
        Card c5 = new Card(8,Suit.Heart);
        d.addCard(c5);
        assertEquals(5, d.size());
    }

    @Test
    public void addCard1() throws Exception {
        assertEquals(4, d.size());
        Card c5 = new Card(8,Suit.Heart);
        Card c6 = new Card(2,Suit.Spade);
        List<Card> cardList = new ArrayList<>();
        cardList.add(c5); cardList.add(c6);
        d.addCard(cardList);
        assertEquals(6, d.size());
    }

    @Test
    public void isDeckEmpty() throws Exception {
        assertFalse(d.isDeckEmpty());
        d.dealCard();d.dealCard();d.dealCard();d.dealCard();
        assertTrue(d.isDeckEmpty());
    }

    @Test
    public void size() throws Exception {
        assertEquals(4, d.size());
    }

}