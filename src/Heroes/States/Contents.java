package Heroes.States;

import Heroes.Heroes;
import Heroes.Entities.Button;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

/**
 * Created with IntelliJ IDEA.
 * User: Lewis
 * Date: 23/02/14
 * Time: 01:44
 * To change this template use File | Settings | File Templates.
 */
public class Contents extends BasicGameState {

    int stateId;
    private StateBasedGame sbg;
    private GameContainer container;

    private Input input;
    private boolean canProgress;

    private Button button[];
    private boolean hover[];
    private int select;
    private Image background;

    private int stubbornness;
    private String[] messages;

    @Override
    public int getID() {
        return stateId;
    }

    public Contents(int id) {
        this.stateId = id;
    }

    public void enter(GameContainer container, StateBasedGame sbg) {
        canProgress = true;

        hover = new boolean[] {false, false, false};
        select = 0;
        stubbornness = 0;
    }


    @Override
    public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
        this.sbg = sbg;
        this.container = container;

        input = Heroes.getInput();

        button = new Button[] {
        new Button("Start",  (Heroes.getWidth()-200)/2, 150, 200, 50, new Image("resources/button1a.png"), new Image("resources/button1b.png")),
        new Button("Don't Start", (Heroes.getWidth()-200)/2, 250, 200, 50, new Image("resources/button2a.png"), new Image("resources/button2b.png")),
        new Button("Leave",  (Heroes.getWidth()-200)/2, 350, 200, 50, new Image("resources/button3a.png"), new Image("resources/button3b.png")),
        };

        background = new Image("resources/background.png");


        this.messages = new String[] {"You didn't start the game.","What were you expecting?","This is going to get boring really quickly","Go away","(>'-')>","<('-'<)","^(' - ')^","<('-'<)","(>'-')>","You're going to lose now"};
    }

    @Override
    public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
        //draw background
        background.draw(0,0);


        //draw buttons (either normal or hovered)
        for (int i = 0; i < 3; i++) {
            if (hover[i] | (select == i + 1)) button[i].getImageB().draw(button[i].getX(),button[i].getY());
            else button[i].getImageA().draw(button[i].getX(),button[i].getY());
        }

        //draw stubborntext
        if (stubbornness > 0 & stubbornness <= 10) g.drawString(messages[stubbornness-1],20,420);
}

    @Override
    public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {

        //Get mouse coordinates
        int destX = input.getMouseX();
        int destY = input.getMouseY();

        //Check if mouse is over a button
        for (int i = 0; i < 3; i++){
            if (button[i].inSpace(destX, destY)) {
                for (int j = 0; j < 3; j++) hover[j] = false;
                hover[i] = true;
                select = 0;
            }
        }

    }

    @Override public void keyPressed(int key, char c) {
        if (key == Input.KEY_W | key == Input.KEY_UP) {
            for (int i = 0; i < 3; i++) hover[i] = false;
            if (select == 0 | select == 1) select = 1;
            else select--;
        }
        else if (key == Input.KEY_S | key == Input.KEY_DOWN) {
            for (int i = 0; i < 3; i++) hover[i] = false;
            if (select == 3) select = 3;
            else if (select == 0) select = 1;
            else select++;
        }
        else if ((key == Input.KEY_Z | key == Input.KEY_ENTER | key==Input.KEY_SPACE) & canProgress) {
            if (select > 0) progress(select-1);
        }
    }
    @Override public void mousePressed(int button, int x, int y) {
        //Check if mouse is clicking a button
        if (button==Input.MOUSE_LEFT_BUTTON) {
            if (hover[0]) progress(0);
            else if (hover[1]) progress(1);
            else if (hover[2]) progress(2);
        }

    }

    private void progress(int value) {
        if (value == 0 & canProgress) {
            sbg.enterState(1, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
        }
        else if (value == 1 & canProgress) {
            stubbornness++;
            if (stubbornness>10) container.exit();
        }
        else if (value == 2 & canProgress) {
            container.exit();
        }
    }
}
