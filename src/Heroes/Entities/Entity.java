package Heroes.Entities;

import org.newdawn.slick.Image;

/**
 * Created with IntelliJ IDEA.
 * User: Lewis
 * Date: 23/02/14
 * Time: 14:45
 * To change this template use File | Settings | File Templates.
 */
abstract public class Entity {

    protected int x;
    protected int y;
    protected int w;
    protected int h;

    protected Image[] sprite;


    public boolean touching(int xIn, int yIn) {
        boolean a = (xIn == x-1 & (yIn >= y & yIn <= y+h));
        boolean b = (xIn == x+w+1 & (yIn >= y & yIn <= y+h));
        boolean c = (yIn == y-1 & (xIn >= x & xIn <= x+w));
        boolean d = (yIn == y+h+1 & (xIn >= x & xIn <= x+w));

        return a | b | c | d;
    }

    public boolean inside(int xIn, int yIn) {
        return (xIn > x & yIn > y & xIn < x+w & yIn < x+h);
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

}
