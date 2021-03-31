package objects;

public abstract class Object {
    int mX;
    int mY;
    int mHeight = 64;
    int mLength = 64;
    Object (int x, int y){
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
}
