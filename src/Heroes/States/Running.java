package Heroes.States;

import Heroes.Entities.Super.Monocle;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Created with IntelliJ IDEA.
 * User: Lewis
 * Date: 23/02/14
 * Time: 06:08
 * To change this template use File | Settings | File Templates.
 */
public class Running extends BasicGameState {

    private final int SIZE = 32;
    private final int SPEED = 5;

    private int stateId;
    private StateBasedGame game;

    private Image bg;
    private TiledMap map;
    private boolean blocked[][];
    private boolean gameInPlay;

    private Monocle mono;

    int xOffset;

    public Running(int id) {
        this.stateId = id;
    }

    public void enter(GameContainer container, StateBasedGame sbg) {
        gameInPlay = true;
        xOffset = 0;

        mono = new Monocle(3*SIZE,9*SIZE);
    }

    @Override
    public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
        this.game = sbg;


        bg = new Image("resources/background2.png");
        map = new TiledMap("resources/map1.tmx");
        blocked = new boolean[map.getWidth()][map.getHeight()];

        for (int x = 0; x < map.getWidth(); x++) {
            for (int y = 0; y < map.getHeight(); y++) {
                int tileID = map.getTileId(x, y, 0);
                String value = map.getTileProperty(tileID, "block", "false");
                if ("true".equals(value)) {
                    blocked[x][y] = true;
                }
            }
        }


    }

    @Override
    public void render(GameContainer container, StateBasedGame sbg, Graphics graphics) throws SlickException {
        if (gameInPlay){
            bg.draw(0,0);
            map.render(xOffset, 0);
            mono.getMoving().draw(mono.getX(),mono.getY());
        }
    }

    @Override
    public void update(GameContainer container, StateBasedGame sbg, int i) throws SlickException {

        //checks in front of mono
        int predictedX = mono.getX()+SPEED-xOffset;
        if (getBlocked(predictedX,mono.getY()+mono.getH()-5)) {
            mono.setX(mono.getX()-SPEED);
        }


        //checks below mono
        int predictedY;
        if (mono.getVelocity()+1 > 20) {
            predictedY = mono.getY() + 20 + mono.getH();
        }
        else if (mono.getVelocity()+1< -20) {
            predictedY = mono.getY() + (-20) + mono.getH();
        }
        //will always happen if not airborne (velocity should be 0)
        else predictedY = mono.getY() + mono.getVelocity()+1 + mono.getH();

        if (mono.isAirborne()) {
            if (getBlocked(mono.getX()+SPEED-xOffset,predictedY)) {
                mono.setAirborne(false);
                mono.setVelocity(0);
                mono.setY(((predictedY / SIZE) * SIZE) - mono.getH());
            }
        }
        else {
            if (!getBlocked(mono.getX()+SPEED-xOffset,predictedY)) {
                //mono is going to fall
                mono.setAirborne(true);
            }
        }

        mono.update();
        xOffset -= SPEED;


        //kills the mono
        if (!mono.isAlive() & gameInPlay) {
            gameInPlay = false;
            sbg.enterState(4, new FadeOutTransition(Color.red), new FadeInTransition(Color.black));
        }

        //mono wins! (he thinks)
        if (mono.isAlive() & xOffset < (-(SIZE*93))) {
            sbg.enterState(3, new FadeOutTransition(Color.white), new FadeInTransition(Color.white));
        }
    }

    @Override public void keyPressed(int key, char c) {
        if (key==Input.KEY_SPACE) {
            mono.jump();
        }
    }

    public boolean getBlocked(int x, int y) {
        return blocked[x/SIZE][y/SIZE];
    }




    @Override
    public int getID() {
        return stateId;
    }

    public int getxOffset() {
        return xOffset;
    }

    public int getSPEED() {
        return SPEED;
    }
}
