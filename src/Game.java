public interface Game {

    boolean playTurn(Deck deck, Hand playerHand, Hand dealerHand);

    void determineWinner(Hand playerHand, Hand dealerHand);


}

