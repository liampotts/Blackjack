public class Card {


    private Suit suit;
    private int value;
    private Name name;


    public Card(Suit suit, Name name) {
        this.suit = suit;
        this.name=name;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return name.getValue();
    }

    public Name getName(){
        return name;
    }


    public String toString() {
        return name + " of " + suit;
    }
}
