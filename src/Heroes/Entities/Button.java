package Heroes.Entities;

import org.newdawn.slick.Image;

/**
 * Created with IntelliJ IDEA.
 * User: Lewis
 * Date: 23/02/14
 * Time: 07:18
 * To change this template use File | Settings | File Templates.
 */
public class Button {

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getH() {
        return h;
    }

    public int getW() {
        return w;
    }


    public Image getImageB() {
        return ib;
    }

    public Image getImageA() {
        return ia;
    }


    public boolean inSpace(int xi, int yi) {
        return (xi > x & xi < x+h) & (yi > y & yi < y+w);
    }


    String s;
    int x;
    int y;
    int h;
    int w;

    Image ia;
    Image ib;

    public Button(String s, int x, int y, int h, int w, Image ia, Image ib) {
        this.x = x;
        this.y = y;
        this.h = h;
        this.w = w;
        this.s = s;
        this.ia = ia;
        this.ib = ib;
    }


}
