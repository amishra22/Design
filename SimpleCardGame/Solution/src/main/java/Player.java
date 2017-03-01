import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private Deck inPlayDeck;
    private Deck reserveDeck;

    public Player(String name, List<Card> firstDealtCards){
        this.name = name;
        this.inPlayDeck = new Deck(firstDealtCards);
        this.reserveDeck = new Deck(new ArrayList<>());
    }

    public String getName(){
        return name;
    }

    public void printInPlayDeck(){
        this.inPlayDeck.printDeck();
    }

    public void printReserveDeck(){
        this.reserveDeck.printDeck();
    }

    public Card dealCard(){
        if(!this.inPlayDeck.isDeckEmpty()){
            return this.inPlayDeck.dealCard();
        }
        else if(!this.reserveDeck.isDeckEmpty()){
            this.reserveDeck.shuffleDeck();
            while(!this.reserveDeck.isDeckEmpty()){
                this.inPlayDeck.addCard(this.reserveDeck.dealCard());
            }
            return this.inPlayDeck.dealCard();
        }
        else {
            return null;
        }
    }

    public void addToReserveDeck(Card c){
        this.reserveDeck.addCard(c);
    }

    public void addToReserveDeck(List<Card> c){
        this.reserveDeck.addCard(c);
    }
}
