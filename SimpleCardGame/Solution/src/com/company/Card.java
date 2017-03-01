package com.company;

/**
 * Created by Abhinav on 16-02-2017.
 */
public class Card implements Comparable{
    private boolean available = true;
    protected int faceVal;
    protected Suit suit;

    public Card(int c, Suit s){
        faceVal = c;
        suit = s;
    }

    public int getFaceVal(){
        return faceVal;
    }

    public Suit suit(){
     return suit;
    }

    public boolean isAvailable(){
        return available;
    }

    public void markAvailable(){
        available = true;
    }

    public void markUnavailable(){
        available = false;
    }

    @Override
    public int compareTo(Object o) {
        Card card = (Card)o;
        int rank1 = this.getFaceVal();
        int rank2 = card.getFaceVal();
        if(rank1 == 1) rank1 = 14;
        if(rank2 == 1) rank2 = 14;
        return rank1-rank2;
    }
}
