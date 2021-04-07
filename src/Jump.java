import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jump {
    private Character mCharacter;
    private int mLenth;
    private final int[] relativeX = {0};
    private boolean mIsInJump = false;
    private int startY;
    private Timer mJumpTimer;
    private int mHeight;

    Jump(Character character){
        mCharacter = character;
        startY = mCharacter.getY();
        mJumpTimer = new Timer (20, new ActionListener() {
            public void actionPerformed (ActionEvent ev) {
                if (relativeX[0] < mLenth - mCharacter.getJumpLength() / 2) {
                    relativeX[0] += 20;
                } else {
                    mIsInJump = false;
                }
                int y;
                y = (int) (mHeight - mCharacter.Jump() * relativeX[0] * relativeX[0]);
                mCharacter.setY(startY - y);
//                System.out.println(mCharacter.getY());
            }
        });
        mJumpTimer.start();
    }

    public void setLenth(int lenth, Character character, int maxLenth, int maxHeight) {
        if (!mIsInJump){
            mLenth = lenth;
            relativeX[0] = -1 * Math.round(maxLenth / 2);
            mIsInJump = true;
            mCharacter = character;
            startY = mCharacter.getY();
            mJumpTimer.start();
            mHeight = maxHeight;
        }
    }

    public void stop(){
        mJumpTimer.stop();
        mIsInJump = false;
    }

    public Character getCharacter() {
        return mCharacter;
    }

    public void setCharacter(Character character) {
        mCharacter = character;
    }

    public int getLenth() {
        return mLenth;
    }

    public boolean isInJump() {
        return mIsInJump;
    }

    public void setInJump(boolean inJump) {
        mIsInJump = inJump;
    }
}
