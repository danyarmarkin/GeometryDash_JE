import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class Jump {
    private Character mCharacter;
    private int mLenth;
    private final int[] relativeX = {0};
    private boolean mInJump = false;
    private int startY;
    private Timer mJumpTimer;

    Jump(Character character){
        mCharacter = character;
        startY = mCharacter.getY();
        mJumpTimer = new Timer (10, new ActionListener() {
            public void actionPerformed (ActionEvent ev) {
                if (relativeX[0] < mLenth - mCharacter.getJumpLength() / 2) {
                    relativeX[0] += 10;
                } else {
                    mInJump = false;
                }
                int y;
                y = (int) (mCharacter.getJumpHeight() - mCharacter.Jump() * relativeX[0] * relativeX[0]);
                mCharacter.setY(startY - y);
//                System.out.println(mCharacter.getY());
            }
        });
        mJumpTimer.start();
    }

    public void setLenth(int lenth, Character character) {
        if (!mInJump){
            mLenth = lenth;
            relativeX[0] = -1 * Math.round(mCharacter.getJumpLength() / 2);
            mInJump = true;
            mCharacter = character;
            startY = mCharacter.getY();
            mJumpTimer.start();
        }
    }

    public void stop(){
        mJumpTimer.stop();
        mInJump = false;
    }

    public Character getCharacter() {
        return mCharacter;
    }

    public void setCharacter(Character character) {
        mCharacter = character;
    }

}
