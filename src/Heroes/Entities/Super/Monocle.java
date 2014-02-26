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

    private static final int GRAVITY = 2;
    private static final int JUMP = 20;


    private Animation moving;

    private boolean airborne;
    private boolean alive;
    private int velocity;

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

        int duration = 200;
        moving = new Animation(sprite, duration, true);
        alive = true;
        airborne = false;

    }

    public void jump() {
        if (!airborne) {
            airborne = true;
            if (velocity > -20) velocity -=JUMP;
        }
    }

    public void update() {
        if (airborne & velocity < 20) velocity +=GRAVITY;
        y += velocity;
        if (x+h < 0) alive = false;
    }

    public boolean isAirborne() {
        return airborne;
    }

    public Animation getMoving() {
        return moving;
    }

    public void setAirborne(boolean airborne) {
        this.airborne = airborne;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public boolean isAlive() {
        return alive;
    }
}
