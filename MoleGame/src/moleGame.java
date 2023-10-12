import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import static javax.swing.SwingUtilities.paintComponent;

public class moleGame extends JFrame implements KeyListener {
    static final IMGmgmt imgMGMT = new IMGmgmt();             // 이미지 일일히 넣기 번잡해서 따로 클래스로 관리
    static gameScore GameScore;                  // 게임 스코어
    static gameSetting setting = new gameSetting();
    private JLabel scoreLabel;                  // 스코어 표시할 라벨
    private JPanel startPage, gamePage, mainPage;
    static private UserSetting user = new UserSetting();//게임유저 객체도 필요할듯
    private int score;
    public moleGame() {
        setTitle("MOLE_GAME");
        setSize(setting.getWidth(),setting.getHeight());
        if(!gameIntro()){
            System.out.println("오류코드 :1 ");
        };
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
    }
    private boolean gameIntro() {
        startPage = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imgMGMT.getIntroBackgrounIMG(), 0, 0, setting.getWidth(), setting.getHeight(), this);
            }
        };

        JLabel titleLabel = new JLabel("두더지게임");

        titleLabel.setBounds((setting.getWidth() / 2) - 100, 50, 200, 30);
        startPage.add(titleLabel);

        JButton startButton = new JButton("시작하기");
        startButton.setBounds((setting.getWidth()/2)-(setting.getStartButtonWidth()/2), 0, setting.getStartButtonWidth(), setting.getStartButtonheight());
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startPage.remove(startButton);
                startPage.remove(titleLabel);
                JButton easyButton = new JButton("easy");
                easyButton.setBounds((setting.getWidth()/2)-(setting.getStartButtonWidth()), 0, setting.getStartButtonWidth(), setting.getStartButtonheight());
                startPage.add(easyButton);
                easyButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        user.setUserLevel(1);
                        user.SETTING();
                    }
                });
                JButton hardButton = new JButton("hard");
                hardButton.setBounds((setting.getWidth()/2), 0, setting.getStartButtonWidth(), setting.getStartButtonheight());
                startPage.add(hardButton);
                hardButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        user.setUserLevel(2);
                        user.SETTING();
                    }
                });
                revalidate();
                repaint();
            }
        });
        startPage.add(startButton);
        startPage.setLayout(null);
        startPage.setSize(setting.getWidth(), setting.getHeight());
        add(startPage); // startPage 패널을 프레임에 추가
        startPage.setVisible(true);
        revalidate(); // 화면 갱신
        repaint(); // 화면 다시 그리기
        return true;
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
