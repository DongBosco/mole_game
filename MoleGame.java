import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoleGame extends JFrame {
    private JButton[] buttons;
    private int score;
    public MoleGame(){
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
    private class MoleListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }
}
