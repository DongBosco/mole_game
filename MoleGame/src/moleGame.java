import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.ArrayList;

public class moleGame extends JFrame {
    static final IMGmgmt imgMGMT = new IMGmgmt();
    static gameScore GameScore;
    static gameSetting setting;
    private JPanel startPage, gamePage, resultPage;
    static private final UserSetting user = new UserSetting();

    public moleGame() {
        GameScore = new gameScore();
        setting = new gameSetting();

        setTitle("MOLE_GAME");
        setSize(setting.getWidth(), setting.getHeight());
        if (!gameIntro()) {
            System.out.println("오류코드 : 1");
        }
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

        JButton startButton = new JButton("시작하기");
        startButton.setBounds((setting.getWidth() / 2) - (setting.getStartButtonWidth() / 2), 0, setting.getStartButtonWidth(), setting.getStartButtonheight());
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startPage.remove(startButton);
                JButton easyButton = new JButton("easy");
                easyButton.setBounds((setting.getWidth() / 2) - (setting.getStartButtonWidth()), 0, setting.getStartButtonWidth(), setting.getStartButtonheight());
                startPage.add(easyButton);
                easyButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        user.setUserLevel(1);
                        user.SETTING();
                        startPage.setVisible(false);
                        gameMode();
                    }
                });

                JButton hardButton = new JButton("hard");
                hardButton.setBounds((setting.getWidth() / 2), 0, setting.getStartButtonWidth(), setting.getStartButtonheight());
                startPage.add(hardButton);
                hardButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        user.setUserLevel(2);
                        user.SETTING();
                        startPage.setVisible(false);
                        gameMode();
                        gamePage.repaint();
                    }
                });
                revalidate();
                repaint();
            }
        });
        startPage.add(startButton);
        startPage.setLayout(null);
        startPage.setSize(setting.getWidth(), setting.getHeight());
        add(startPage);
        startPage.setVisible(true);
        repaint();
        return true;
    }

    private void gameMode() {
        gamePage = new GamePanel();
        add(gamePage);
        gamePage.setVisible(true);
        gamePage.setLayout(null);
    }

    class GamePanel extends JPanel {
        private java.util.List<Mole> moles;
        public GamePanel() {
            moles = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                moles.add(new Mole());
                new Thread(moles.get(i)).start();
            }
            addKeyListener(new MoleKeyListener());
            setFocusable(true);
            requestFocus();
            setPreferredSize(new Dimension(setting.getWidth(), setting.getHeight()));
            Timer timer = new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateGame();
                    repaint();
                }
            });
            timer.start();
        }

        private void updateGame() {
            for (Mole mole : moles) {
                if (!mole.isVisible()) {
                    Random rand = new Random();
                    if (rand.nextInt(100) < 10) {
                        mole.show();
                    }
                }
            }
        }

        class MoleKeyListener extends KeyAdapter {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_SPACE) {
                    for (Mole mole : moles) {
                        if (mole.isVisible()) {
                            GameScore.incrementScore();
                            mole.hide();
                        }
                    }
                }
            }
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(imgMGMT.getBackgroundIMG(), 0, 0, setting.getWidth(), setting.getHeight(), this);
            drawMoles(g);
        }

        private void drawMoles(Graphics g) {
            for (Mole mole : moles) {
                if (mole.isVisible()) {
                    g.drawImage(imgMGMT.getMoleIMG(), mole.x, mole.y, setting.getMoleWidth(), setting.getMoleHeight(), this);
                }
            }
        }
    }

    class Mole implements Runnable {
        private int x;
        private int y;
        private boolean visible;
        private int MOLE_PERIOD;

        public Mole() {
            visible = false;
            this.MOLE_PERIOD = user.getPerriodMole();
        }

        public void show() {
            Random rand = new Random();
            x = rand.nextInt(setting.getWidth() - setting.getMoleWidth());
            y = rand.nextInt(setting.getHeight() - setting.getMoleHeight());
            visible = true;
        }

        public boolean isVisible() {
            return visible;
        }

        public void hide() {
            visible = false;
        }

        @Override
        public void run() {
            while (true) {
                show();
                try {
                    Thread.sleep(MOLE_PERIOD);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                hide();
            }
        }
    }
}
