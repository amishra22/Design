import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {

    private List<Card> cards;

    public Deck(){
        this.cards = new ArrayList<>();
        for(int i=1; i<=13; i++) {
            for(int s=0; s<=3; s++){
                Suit suit = Suit.getSuitFromValue(s);
                this.cards.add(new Card(i,suit));
            }
        }
    }

    public Deck(List<Card> cards){
        this.cards = cards;
        shuffleDeck();
    }

    public void shuffleDeck(){
        Collections.shuffle(this.cards);
    }

    public Card dealCard(){
        if(isDeckEmpty()) return null;
        return cards.remove(0);
    }

    public void addCard(Card c){
        cards.add(c);
    }

    public void addCard(List<Card> cardsToAdd){
        for(int i=0;i<cardsToAdd.size();i++){
            cards.add(cardsToAdd.get(i));
        }
    }

    public boolean isDeckEmpty(){
        return cards.size() == 0;
    }

    public int size(){
        return cards.size();
    }

    public void printDeck(){
        for(int i=0; i<cards.size(); i++){
            System.out.print(cards.get(i) + " ");
        }
        System.out.println();
    }
}
