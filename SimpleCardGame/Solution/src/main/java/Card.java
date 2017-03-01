
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

    public Suit getsuit(){
     return suit;
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

    @Override
    public String toString(){
        String faceValString = String.valueOf(faceVal);
        if(faceValString.equalsIgnoreCase("11")){
            faceValString = "J";
        }
        else if (faceValString.equalsIgnoreCase("12")){
            faceValString = "Q";
        }
        else if (faceValString.equalsIgnoreCase("13")){
            faceValString = "K";
        }
        else if (faceValString.equalsIgnoreCase("1")){
            faceValString = "A";
        }

        if(suit.getValue() == 0){
            return faceValString + " Club";
        }
        else if(suit.getValue() == 1){
            return faceValString + " Diamond";
        }
        else if(suit.getValue() == 2){
            return faceValString + " Heart";
        }
        else{
            return faceValString + " Spade";
        }
    }
}
