package objects;

import java.awt.*;

public abstract class Object {
    int mX;
    int mY;
    int mHeight = 64;
    int mLength = 64;
    Image mIcon;
    Object (int x, int y, Image image){
        mIcon = image;
        mX = x;
        mY = y;
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

    public int getHeight() {
        return mHeight;
    }

    public int getLength() {
        return mLength;
    }

    public Image getIcon() {
        return mIcon;
    }

    public void setIcon(Image icon) {
        mIcon = icon;
    }

    public int[] getPosition() {
        int[] pos = {getX(), getY()};
        return pos;
    }
}
