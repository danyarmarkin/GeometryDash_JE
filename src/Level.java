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

    Level(String levelName) {
        this.levelName = levelName;
        levelFrame = new JFrame(levelName);

        levelFrame.setVisible(true);

        this.setBounds(0,0,1920,1080);

        levelFrame.setSize(new Dimension(1920, 1080));
        levelFrame.add(this);


        mCharacter = new Character(0, 300, 990);

        mJump = new Jump(mCharacter);

        levelFrame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    mJump.setLenth(mCharacter.getJumpLength(), mCharacter);
                }
            }
        });
//        levelFrame.addKeyListener(new KeyAdapter() {
//            public void keyPressed(KeyEvent e) {
//                if(e.getKeyCode()==KeyEvent.VK_UP){
//                    mJump.setLenth(mCharacter.getJumpLength() - 100, mCharacter);
//                }
//            }
//        });
//        levelFrame.addKeyListener(new KeyAdapter() {
//            public void keyPressed(KeyEvent e) {
//                if(e.getKeyCode()==KeyEvent.VK_DOWN){
//                    mJump.setLenth(mCharacter.getJumpLength() + 100, mCharacter);
//                }
//            }
//        });

        frameRepaint();

    }

    public void frameRepaint(){
        Timer timer = new Timer (10, new ActionListener() {
            public void actionPerformed (ActionEvent ev) {
                mCharacter = mJump.getCharacter();
                if (mCharacter.getY() + 62 > 864) {
                    mCharacter.setY(800);
                    mJump.stop();
                }
                repaint();
            }
        });
        timer.start();
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(mCharacter.getImage(), mCharacter.getX(), mCharacter.getY(), null);
    }
    public void paint(Graphics g) {
        super.paint(g);
        g.drawLine(0, 864, 1920, 864);
        for (int i = -20; i < 192; i++) {
            g.drawLine(i*10, 864, i*10 + 50, 1000);
        }
    }

}
