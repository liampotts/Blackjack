import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> cardsInHand;


    public Hand() {

        cardsInHand = new ArrayList<Card>();
    }

    public void addCard(Card card) {

        cardsInHand.add(card);
    }

    public ArrayList<Card> getCards() {

        return cardsInHand;
    }


    public int getTotal() {

        int total = 0;
        boolean hasAce = false;
        for (Card card : cardsInHand) {
            Name name = card.getName();
            int value=name.getValue();

            //Aces can either be 1 or 11 depending on what benefits player most
            if (name == Name.ACE) {
                hasAce = true;
                total += 11;
            }
            else {
                total += value;
            }
        }

        // If the hand has Ace and counting it as 11 would cause the hand to bust, count it as 1 instead
        if (hasAce==true ) {
            if (total > 21) {
                total = total - 10;
            }
        }
        return total;
    }


    public boolean isBlackjack() {

        if (getTotal() == 21 && cardsInHand.size() == 2) {
            return true;
        }

        return false;
    }

    public boolean isValid(){
        return getTotal()<21;
    }


    public boolean isBust() {
        return getTotal() > 21;
    }

    public String toString(){
            String returnMe = "";
            for (Card card : cardsInHand) {
                returnMe += card + ", ";
            }
            return returnMe;
        }
    }



