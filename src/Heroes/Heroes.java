package Heroes;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created with IntelliJ IDEA.
 * User: Lewis
 * Date: 22/02/14
 * Time: 23:13
 * To change this template use File | Settings | File Templates.
 */

public class Heroes extends StateBasedGame{

    public static void main(String[] args) throws SlickException {

    }

    public Heroes(String name) {
        super(name);
    }

    public void initStatesList(GameContainer container) throws SlickException {
        addState((new Heroes.States.Menu()));
    }

}
