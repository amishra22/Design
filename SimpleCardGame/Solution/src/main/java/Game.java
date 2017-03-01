import java.util.ArrayList;
import java.util.List;

public class Game {

    private Player p1;
    private Player p2;
    private Deck deck;
    /**
     * Constructor that creates a new game, assigns two decks to each player
     * @param player1Name Name of first Player
     * @param player2Name Name of second Player
     */
    public Game(String player1Name, String player2Name, Deck deck){

        /**
         * Create new Deck and Shuffle it
         */
        this.deck = deck;
        this.deck.shuffleDeck();

        /**
         * Create two decks for each player
         */
        List<Card> player1Cards = new ArrayList<>();
        List<Card> player2Cards = new ArrayList<>();
        boolean flag = false;
        while(!deck.isDeckEmpty()){
            if(!flag){
                player1Cards.add(deck.dealCard());
                flag = true;
            }
            else {
                player2Cards.add(deck.dealCard());
                flag = false;
            }
        }

        /**
         * Create two Players
         */
        this.p1 = new Player(player1Name, player1Cards);
        this.p2 = new Player(player2Name, player2Cards);
    }


    public String beginGame() throws InterruptedException {
        int iterCount = 1;
        String winner = new String();
        while(true){
            System.out.println();
            System.out.println("Iteration " + iterCount);

            Card c1 = p1.dealCard();
            Card c2 = p2.dealCard();

            System.out.println(p1.getName() + " deals " + c1);
            System.out.println(p2.getName() + " deals " + c2);

            if(c1 == null){
                return p2.getName();
            }
            else if (c2 == null){
                return p1.getName();
            }

            if(c1.compareTo(c2) < 0){
                p2.addToReserveDeck(c1);
                p2.addToReserveDeck(c2);
            }
            else if (c1.compareTo(c2) == 0){
                List<Card> cardList = new ArrayList<>();
                cardList.add(c1);
                cardList.add(c2);
                warEncountered(cardList, winner);
            }
            else {
                p1.addToReserveDeck(c1);
                p1.addToReserveDeck(c2);
            }

            System.out.print(p1.getName() + "'s current deck : ");
            p1.printInPlayDeck();
            System.out.print(p1.getName() + "'s reserve deck : ");
            p1.printReserveDeck();

            System.out.print(p2.getName() + "'s current deck : ");
            p2.printInPlayDeck();
            System.out.print(p2.getName() + "'s reserve deck : ");
            p2.printReserveDeck();

            //Thread.sleep(200);
            iterCount++;
            if(winner.length() != 0) return winner;
        }
    }

    private void warEncountered(List<Card> cardList, String winner){
        System.out.println("War Encountered !!!");

        Card c3 = p1.dealCard();
        Card c4 = p1.dealCard();
        Card c5 = p2.dealCard();
        Card c6 = p2.dealCard();

        System.out.println(p1.getName() + " deals two cards " + c3 + ", " +c4);
        System.out.println(p2.getName() + " deals two cards " + c5 + ", " +c6);


        if(c3 == null || c4 == null){
            winner = p2.getName();
            return;
        }
        else if (c5 == null || c6 == null){
            winner = p1.getName();
            return;
        }

        cardList.add(c3);
        cardList.add(c4);
        cardList.add(c5);
        cardList.add(c6);

        if(c4.compareTo(c6) < 0){
            p2.addToReserveDeck(cardList);

        }
        else if (c4.compareTo(c6) == 0){
            warEncountered(cardList, winner);
        }
        else {
            p1.addToReserveDeck(cardList);
        }
        return;
    }
}
