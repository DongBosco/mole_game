import javax.swing.*;

public class MoleGame extends JFrame {
    private JButton[] buttons;
    private Timer timer;
    private int score;
    public MoleGame(){
        setTitle("MOLE_GAME_JAVA");
        setSize(1920,1080);
        buttons = new JButton[5];
        for (int i =0; i < buttons.size; i++){
            buttons[i] = new JButton("MOLE");
            add(buttons[i]);
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
