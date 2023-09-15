public class GameFacade  {

    private Game easyGame;
    private Game hardGame;


    public GameFacade(){
        easyGame = new EasyGame();
        hardGame= new HardGame();
    }

    public boolean playTurnEasy(Deck deck, Hand playerHand, Hand dealerHand){
        return easyGame.playTurn(deck,playerHand,dealerHand);
    }

    public boolean playTurnHard(Deck deck, Hand playerHand, Hand dealerHand){
        return hardGame.playTurn(deck,playerHand,dealerHand);
    }

    public void determineWinnerHard(Hand playerHand, Hand dealerHand){
         hardGame.determineWinner(playerHand,dealerHand);
    }

    public void determineWinnerEasy(Hand playerHand, Hand dealerHand){
        easyGame.determineWinner(playerHand,dealerHand);
    }


    public Deck setupDeck() {
        // Create a deck and shuffle it
        Deck deck = Deck.makeDeck();
        deck.shuffle();
        return deck;
    }


    public Hand setupPlayerHand(Deck deck) {

        // Create a hand for the player and a hand for the dealer
        Hand playerHand = new Hand();


        // Deal two cards to the player and two cards to the dealer
        playerHand.addCard(deck.deal());
        playerHand.addCard(deck.deal());

        return playerHand;


    }


    public Hand setupDealerHand(Deck deck) {
        Hand dealerHand = new Hand();
        dealerHand.addCard(deck.deal());
        dealerHand.addCard(deck.deal());
        return dealerHand;
    }



    public boolean checkBlackjack(Hand playerHand, Hand dealerHand) {
        // Check for blackjacks
        if (playerHand.isBlackjack()) {
            System.out.println("Your hand: " + playerHand);
            System.out.println("You have a blackjack! You win.");
            return true;
        }
        if (dealerHand.isBlackjack()) {

            System.out.println("Your hand: " + playerHand);
            System.out.println("Dealer hand: " + dealerHand);
            System.out.println("The dealer has a blackjack. You lose.");
            return true;
        }
        return false;
    }

    public void checkDealerHand(Deck deck, Hand dealerHand){
        System.out.println("Dealer's hand: " + dealerHand);
        while (dealerHand.getTotal() < 17) {
            dealerHand.addCard(deck.deal());
            System.out.println("Dealer hand: " + dealerHand);

        }
    }

}
