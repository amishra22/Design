import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class GameTest {
    Game game;

    @Mock
    private Deck mockDeck;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        Mockito.doNothing().when(mockDeck).shuffleDeck();
        Card c1 = new Card(5,Suit.Club);
        Card c2 = new Card(7,Suit.Diamond);
        when(mockDeck.dealCard()).thenReturn(c1).thenReturn(c2);
        when(mockDeck.isDeckEmpty()).thenReturn(false).thenReturn(false).thenReturn(true);
        game = new Game("TestPlayer1", "TestPlayer2", mockDeck);
    }

    @Test
    public void beginGame() throws Exception {
        String s = game.beginGame();
        assertEquals("TestPlayer2",s);
    }

}