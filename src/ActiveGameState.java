public class ActiveGameState implements GameState{

    public String getState(){
        return "Active ";
    }

    public GameState changeState(){
        return new GameOverState();
    }

}
