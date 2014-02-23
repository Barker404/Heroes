package Heroes.States;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Created with IntelliJ IDEA.
 * User: Lewis
 * Date: 23/02/14
 * Time: 06:08
 * To change this template use File | Settings | File Templates.
 */
public class Running extends BasicGameState {

    private final int SPEED = 4;

    private int stateId;
    private StateBasedGame game;

    private Image bg;
    private TiledMap map;

    int xOffset;

    public Running(int id) {
        this.stateId = id;
    }

    @Override
    public int getID() {
        return stateId;
    }

    @Override
    public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
        this.game = sbg;

        bg = new Image("resources/background2.png");
        map = new TiledMap("resources/map0a.tmx");
        //######

        //######
        xOffset = 0;
    }

    @Override
    public void render(GameContainer container, StateBasedGame sbg, Graphics graphics) throws SlickException {

        bg.draw(0,0);
        map.render(xOffset, 0);

    }

    @Override
    public void update(GameContainer container, StateBasedGame sbg, int i) throws SlickException {
        xOffset -= SPEED;
    }

    public int getxOffset() {
        return xOffset;
    }

    public int getSPEED() {
        return SPEED;
    }
}
