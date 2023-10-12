import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class moleGame extends JFrame implements KeyListener {
    static final IMGmgmt imgMGMT;             // 이미지 일일히 넣기 번잡해서 따로 클래스로 관리
    static {
        try {
            imgMGMT = new IMGmgmt();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private int gameScore;                      // 게임 스코어
    private JLabel scoreLabel;                  // 스코어 표시할 라벨
    //게임유저 객체도 필요할듯

    private JButton[] buttons;
    private int score;
    public moleGame() {
        setTitle("MOLE_GAME_JAVA");
        setSize(1920,1080);
        setLayout(new GridLayout(3, 3));
        buttons = new JButton[9];
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("Mole");
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 20));
            buttons[i].setEnabled(false);
            buttons[i].addActionListener(new MoleListener());
            add(buttons[i]);
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private class MoleListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
