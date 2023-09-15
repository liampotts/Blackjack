public class GameContext {

    private GameState gamestate;


    public GameContext(GameState gs){
        this.gamestate=gs;
    }


    public String getState(){
        return gamestate.getState();
    }

    public GameState changeState(){
        return gamestate.changeState();
    }
}
