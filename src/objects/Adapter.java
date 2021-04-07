package objects;

import java.awt.*;
import java.util.ArrayList;

public abstract class Adapter {
    ArrayList<Image> mIconsList;
    ArrayList<int[]> mAbsolutePositions;
    ArrayList<String> mType;

    Adapter(){
        mIconsList = new ArrayList<Image>();
        mAbsolutePositions = new ArrayList<int[]>();
        mType = new ArrayList<String>();
    }

    public ArrayList<Image> getIconsList() {
        return mIconsList;
    }

    public void setIconsList(ArrayList<Image> iconsList) {
        mIconsList = iconsList;
    }

    public ArrayList getAbsolutePositions() {
        return mAbsolutePositions;
    }

    public void setAbsolutePositions(ArrayList absolutePositions) {
        mAbsolutePositions = absolutePositions;
    }

    public void add(String type, Image icon, int[] pos){
        mIconsList.add(icon);
        mAbsolutePositions.add(pos);
        mType.add(type);
    }

    public int size(){
        return  mIconsList.size();

    }

    public Object getObject(int i){
        String type = mType.get(i);
        Image icon = mIconsList.get(i);
        int[] pos = mAbsolutePositions.get(i);
        switch (type){
            case ("block"):
                return new Block(pos[0], pos[1]);
            case ("triangle"):
                return new Triangle(pos[0], pos[1]);
            default:
                return new Block(0, 0);
        }
    }

    public String getType(int i) {
        return mType.get(i);
    }

    public Image getIcon(int i){
        return mIconsList.get(i);
    }

    public int[] getPosition(int i){
        return mAbsolutePositions.get(i);
    }

    public int x(int units){
        return units * 64;
    }
    public int y(int units){
        return 800 - units * 64;
    }

    public void move(int delta){
        for (int i = 0; i < mAbsolutePositions.size(); i++) {
            int x = mAbsolutePositions.get(i)[0];
            int y = mAbsolutePositions.get(i)[1];
            mAbsolutePositions.set(i, new int[]{x - delta, y});
        }
    }
}
