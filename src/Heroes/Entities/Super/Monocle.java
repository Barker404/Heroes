package Heroes.Entities.Super;

import Heroes.Entities.Entity;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Created with IntelliJ IDEA.
 * User: Lewis
 * Date: 23/02/14
 * Time: 16:04
 * To change this template use File | Settings | File Templates.
 */

public class Monocle extends  Entity{

    private Animation moving;

    public Monocle(int x, int y) {

        this.x = x;
        this.y = y;

        this.w = 32;
        this.h = 86;

        try {
            sprite = new Image[] {new Image("resources/monocle1.png"), new Image("resources/monocle2.png")};
        }
        catch (SlickException e)
        {
            e.printStackTrace();
        }

        int duration = 500;
        moving = new Animation(sprite, duration, false);

    }

    public void jump() {

    }


    public Animation getMoving() {
        return moving;
    }

    public void update() {
        if(collideFront) y -=
    }
}
