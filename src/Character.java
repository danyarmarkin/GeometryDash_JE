import javax.swing.*;
import java.awt.*;

public class Character {
    private int mMode = 0;
    private int mX;
    private int mY;
    private Image cube1 = new ImageIcon("drawable/cube/cube_1.png").getImage();
    private int mJumpLength = 438;
    private int mJumpHeight = 190;
//    mode = 0 --> cube
//    mode = 1 --> ship
//    mode = 2 --> circle
//    mode = 3 --> wawe

    Character(int mode, int x, int y) {
        mX = x;
        mY = y;
        mMode = mode;
    }

    public float Jump(){
        if (mMode == 0) return 0.00396f;
        return 1.5f;
    }

    public int getMode() {
        return mMode;
    }

    public void setMode(int mode) {
        mMode = mode;
    }

    public int getX() {
        return mX;
    }

    public void setX(int x) {
        mX = x;
    }

    public int getY() {
        return mY;
    }

    public void setY(int y) {
        mY = y;
    }

    public Image getImage() {
        return cube1;
    }

    public int getJumpLength() {
        return mJumpLength;
    }

    public int getJumpHeight() {
        return mJumpHeight;
    }
}
