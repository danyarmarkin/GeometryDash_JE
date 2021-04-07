import objects.ObjectsAdapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Level extends  JPanel{
    private JFrame levelFrame;
    private String levelName;
    private Character mCharacter;
    private Jump mJump;
    private ObjectsAdapter mObjects;

    Level(String levelName) {
        this.levelName = levelName;
        levelFrame = new JFrame(levelName);
        levelFrame.setVisible(true);
        this.setBounds(0,0,1920,1080);
        levelFrame.setSize(new Dimension(1920, 1080));
        levelFrame.add(this);

        mCharacter = new Character(0, 300, 990);
        mJump = new Jump(mCharacter);
        mObjects = new ObjectsAdapter();

        levelFrame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_SPACE){
//                    mJump.stop();
                    mJump.setLenth(/*mCharacter.getJumpLength()*/ 100000, mCharacter, mCharacter.getJumpLength(), mCharacter.getJumpHeight());
                }
            }
        });
        frameRepaint();

    }

    public void frameRepaint(){
        Timer timer = new Timer (20, new ActionListener() {
            public void actionPerformed (ActionEvent ev) {
                mObjects.move(15);
                mCharacter = mJump.getCharacter();
                if (mCharacter.getY() + 63 >= 864) {
                    mCharacter.setY(800);
                    mJump.stop();
//                    mJump.setLenth(100000, mCharacter, 0,0);
                }
                repaint();

            }
        });
        timer.start();
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < mObjects.size(); i++) {
            g.drawImage(mObjects.getIcon(i), mObjects.getPosition(i)[0], mObjects.getPosition(i)[1], null);
        }
        g.drawImage(mCharacter.getImage(), mCharacter.getX(), mCharacter.getY(), null);
    }
    public void paint(Graphics g) {
        super.paint(g);
        g.drawLine(0, 864, 1920, 864);
        for (int i = -20; i < 192; i++) {
            g.drawLine(i*10, 864, i*10 + 50, 1000);
        }

//            ====grid====
//        for (int i = 0; i < 256; i++) {
//            g.drawLine(i*64, 0, i*64, 864);
//        }
//        for (int i = 0; i < 20; i++) {
//            g.drawLine(0, 800 - i * 64, 1920, 800 - i * 64);
//        }
    }

}
