package Heroes.States;

/**
 * Created with IntelliJ IDEA.
 * User: Lewis
 * Date: 23/02/14
 * Time: 19:12
 * To change this template use File | Settings | File Templates.
 */

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Silence extends BasicGameState {

    private int stateId;
    private StateBasedGame game;

    private Image[] end;
    private int screen;

    public void enter(GameContainer container, StateBasedGame sbg) {
        screen = 0;
    }

    public Silence(int id) {
        this.stateId = id;
    }

    @Override
    public int getID() {
        return stateId;
    }

    @Override
    public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
        this.game = sbg;
        end = new Image[] {new Image("resources/end1.png"),
                        new Image("resources/end2.png"),
                        new Image("resources/end3.png"),
                        new Image("resources/end4.png"),
                        new Image("resources/end5.png"),
                        new Image("resources/end6.png")};
    }

    @Override
    public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
        if (screen >= 0 & screen <= 5) {
            g.drawImage(end[screen], 0, 0);
        }
    }

    @Override
    public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
        if (screen == 6) {
            sbg.enterState(0, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
        }
    }

    @Override public void keyPressed(int key, char c) {
        if (key == Input.KEY_Z | key == Input.KEY_ENTER | key==Input.KEY_SPACE) {
            screen++;
        }
    }
    @Override public void mousePressed(int button, int x, int y) {
        //Check if mouse is clicking a button
        if (button==Input.MOUSE_LEFT_BUTTON) {
            screen++;
        }

    }
}