import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        GameState ags= new ActiveGameState();
        GameContext gameContext= new GameContext(ags);

        Scanner input = new Scanner(System.in);

        System.out.println("Easy or Hard (E/H)? ");

        String playerC = input.nextLine().toUpperCase();

        GameFacade gf = new GameFacade();

        //Set up deck and both players hands
        Deck deck = gf.setupDeck();
        Hand playerHand=gf.setupPlayerHand(deck);
        Hand dealerHand=gf.setupDealerHand(deck);

        //Check to see if you got blackjack
        boolean blackjack=gf.checkBlackjack(playerHand,dealerHand);
        if (blackjack){

            String s=gameContext.changeState().getState();
            System.out.println(s);
            return;
        }
        if (!playerC.equals("E") && !playerC.equals("H")) {
            System.out.println("Please try again with a valid answer (only E for easy or H for Hard)");
            return;
        }
        if (playerC.equals("E")) {
            System.out.println("Playing on Easy mode ");


            boolean bust= gf.playTurnEasy(deck,playerHand,dealerHand);

            if (bust){
                String s=gameContext.changeState().getState();
                System.out.println(s);
                return;

            }

            gf.checkDealerHand(deck,dealerHand);
            gf.determineWinnerEasy(playerHand,dealerHand);
        }

        else {
            System.out.println("Playing on Hard mode ");
            boolean bust= gf.playTurnHard(deck,playerHand,dealerHand);

            if (bust){
                String s=gameContext.changeState().getState();
                System.out.println(s);
                return;

            }
            gf.checkDealerHand(deck,dealerHand);
            gf.determineWinnerHard(playerHand,dealerHand);

        }
    }

}
