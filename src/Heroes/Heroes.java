package Heroes;

import Heroes.States.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created with IntelliJ IDEA.
 * User: Lewis
 * Date: 22/02/14
 * Time: 23:13
 * To change this template use File | Settings | File Templates.
 */

public class Heroes extends StateBasedGame{

    private final  int CONTENTS = 0;
    private final  int DEBUT = 1;
    private final  int RUNNING = 2;
    private final  int SILENCE = 3;
    private final  int TERMINATION = 4;

    private final static int HEIGHT = 15;
    private final static int WIDTH = 20;

    static Input input;
    static Graphics graphics;

    public static void main(String[] args) throws SlickException {
        System.setProperty("org.lwjgl.librarypath",System.getProperty("user.home") + "/natives");
        System.setProperty("net.java.games.input.librarypath", System.getProperty("org.lwjgl.librarypath"));

        try {
            input = new Input(HEIGHT*32);
            AppGameContainer app = new AppGameContainer(new Heroes("Heroes"));
            app.setDisplayMode(32*WIDTH, 32*HEIGHT,false);
            app.setTargetFrameRate(60);
            app.start();
        }
        catch (SlickException e)
        {
            e.printStackTrace();
        }
    }

    public Heroes(String name) {
        super(name);
    }

    public void initStatesList(GameContainer container) throws SlickException {
        this.addState(new Contents(CONTENTS));
        this.addState(new Debut(DEBUT));
        this.addState(new Running(RUNNING));
        this.addState(new Silence(SILENCE));
        this.addState(new Termination(TERMINATION));
    }


    public static Input getInput() {
        return input;
    }

    public static Graphics getGraphics() {
        return graphics;
    }

    public static int getHeight() {
        return 32*HEIGHT;
    }

    public static int getWidth() {
        return 32*WIDTH;
    }
}
