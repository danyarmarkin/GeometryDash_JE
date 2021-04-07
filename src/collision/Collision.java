package collision;

import objects.Object;

public class Collision {
    private byte mSize;
    private Object mObject;

    Collision(byte size, Object object){
        mSize = size;
        mObject = object;
    }

    public byte getSize() {
        return mSize;
    }

    public Object getObject() {
        return mObject;
    }
}
