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
 * Time: 06:10
 * To change this template use File | Settings | File Templates.
 */
public class Termination extends BasicGameState {

    private int stateId;
    private StateBasedGame game;
    private boolean go;
    private Image gameOver;

    public Termination(int id) {
        this.stateId = id;
    }

    @Override
    public int getID() {
        return stateId;
    }

    public void enter(GameContainer container, StateBasedGame sbg) {
        go = false;
    }

    @Override
    public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
        this.game = sbg;
        gameOver = new Image("resources/GameOver.png");
    }

    @Override
    public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawImage(gameOver, 0, 0);
    }

    @Override
    public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
        if (go) {
            sbg.enterState(0, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
        }

    }

    @Override public void keyPressed(int key, char c) {
        if (key == Input.KEY_Z | key == Input.KEY_ENTER | key == Input.KEY_SPACE) {
            go = true;
        }
    }
    @Override public void mousePressed(int button, int x, int y) {
        //Check if mouse is clicking a button
        if (button == Input.MOUSE_LEFT_BUTTON) {
            go = true;
        }

    }
}