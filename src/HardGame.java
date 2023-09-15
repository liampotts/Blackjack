import java.util.Scanner;

public class HardGame implements Game{

    private static HardGame game;

    public HardGame() {
    }


    public boolean playTurn(Deck deck, Hand playerHand, Hand dealerHand){

        // Allow the player to hit or stand
        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println("Your hand: " + playerHand);
            System.out.println("Your total: " + playerHand.getTotal());
            System.out.println("Dealer's hand: " + dealerHand.getCards().get(0) + ", [hidden]");
            System.out.print("Hit or stand (H/S)? ");
            String playerChoice = input.nextLine().toUpperCase();
            if (playerChoice.equals("S")) {
                break;
            } else if (playerChoice.equals("H")) {
                playerHand.addCard(deck.deal());
                if (playerHand.isBust()) {
                    System.out.println("You have " + playerHand + "TOTAL: " + playerHand.getTotal() + "\n" + "You have gone bust. You lose.");
                    return true;
                }
            }
        }
        return false;
    }


    public void determineWinner(Hand playerHand, Hand dealerHand){

        if (dealerHand.isBust()) {
            System.out.println("The dealer has gone bust.");
            System.out.println("YOU WIN!");

        } else if (playerHand.getTotal() > dealerHand.getTotal()) {
            System.out.println("You have "+playerHand+ "TOTAL: "+playerHand.getTotal()+"\n"+
                    "Dealer has "+dealerHand+"TOTAL: "+dealerHand.getTotal() +"\n"+ "YOU WIN!");

        } else if (playerHand.getTotal() < dealerHand.getTotal()) {
            System.out.println("You have "+playerHand+ "TOTAL: "+playerHand.getTotal()+"\n"+
                    "Dealer has "+dealerHand+"TOTAL: "+dealerHand.getTotal() + "\n"+ "YOU LOSE!");
        } else {
            System.out.println("You have "+playerHand+ "TOTAL: "+playerHand.getTotal()+"\n"+
                    "Dealer has "+dealerHand+"TOTAL: "+dealerHand.getTotal() + " It's a tie but unfortunately that means...");
            System.out.println("YOU LOSE (tie goes to the house on hard mode)");
        }
    }

}
