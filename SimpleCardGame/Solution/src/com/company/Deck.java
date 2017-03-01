package com.company;

import java.util.Random;

/**
 * Created by Abhinav on 16-02-2017.
 */
public class Deck {

    private Card[] cards;
    private int numCards;

    Deck(){
        cards = new Card[52];
        numCards = 0;
        for(int i=1; i<=13; i++) {
            for(int s=0; s<=3; s++){
                Suit suit = Suit.getSuitFromValue(s);
                cards[numCards] = new Card(i,suit);
                cards[numCards].markAvailable();
                numCards++;
            }
        }
    }

    public void shuffle(){
        for(int i=0; i< numCards; i++){
            Random rand = new Random();
            int index = rand.nextInt(numCards);
            Card card = cards[i];
            cards[i] = cards[index];
            cards[index] = card;
        }
    }

    public int cardsLeft(){

        return 0;
    }

    public Card dealCard(){
        if(numCards == 0) return null;
        numCards--;
        if(!cards[numCards].isAvailable()) return null;
        cards[numCards].markUnavailable();
        return cards[numCards];
    }
}
