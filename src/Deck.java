import java.util.*;


public class Deck {
    private ArrayList<Card> cards;
    private static Deck deck;


    private Deck() {
        cards = new ArrayList<Card>();

        for (Suit suit : Suit.values()) {
            for (Name name : Name.values()) {
                cards.add(new Card(suit, name));
            }
        }
    }

    public static Deck makeDeck(){
        if (deck==null){
            deck=new Deck();
        }
        return deck;
    }

    public void shuffle() {
        Random rand = new Random();

        for (int i = cards.size() - 1; i > 0; i--) {

            int j = rand.nextInt(i + 1);

            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }

    public Card deal() {
        return cards.remove(0);
    }

    public int size() {
        return cards.size();
    }


    public String toString(){
        return cards.toString();
    }
}
