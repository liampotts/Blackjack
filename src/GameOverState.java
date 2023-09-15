public class GameOverState implements GameState{



    public String getState() {
        return "Game Over";

    }

    public GameState changeState(){
        return new ActiveGameState();
    }


}
