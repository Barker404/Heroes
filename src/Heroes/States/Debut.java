package Heroes.States;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

/**
 * Created with IntelliJ IDEA.
 * User: Lewis
 * Date: 23/02/14
 * Time: 06:39
 * To change this template use File | Settings | File Templates.
 */
public class Debut extends BasicGameState{

    private int stateId;

    private StateBasedGame game;

    private Image[] intro;
    private int screen;

    public Debut(int id) {
        this.stateId = id;
    }

    @Override
    public int getID() {
        return stateId;
    }

    @Override
    public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
        this.game = sbg;

        intro = new Image[] {new Image("resources/intro1.png"),
                            new Image("resources/intro2.png"),
                            new Image("resources/intro3.png"),
                            new Image("resources/intro4.png")};

        screen = 0;
    }

    @Override
    public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
        if (screen >= 0 & screen <= 3) {
            g.drawImage(intro[screen], 0, 0);
        }
    }

    @Override
    public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
        if (screen == 4) {
            sbg.enterState(2, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
        }
    }

    @Override public void keyPressed(int key, char c) {
        if (key == Input.KEY_Z | key == Input.KEY_ENTER) {
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
