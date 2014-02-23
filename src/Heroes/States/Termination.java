package Heroes.States;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created with IntelliJ IDEA.
 * User: Lewis
 * Date: 23/02/14
 * Time: 06:10
 * To change this template use File | Settings | File Templates.
 */
public class Termination extends BasicGameState {

    private int stateId;
    private StateBasedGame game;

    public Termination(int id) {
        this.stateId = id;
    }

    @Override
    public int getID() {
        return stateId;
    }

    @Override
    public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
        this.game = sbg;
    }

    @Override
    public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {

    }

    @Override
    public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {

    }
}