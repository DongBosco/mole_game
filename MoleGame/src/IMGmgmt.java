import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class IMGmgmt extends JFrame {
    private Image backgroundIMG ;
    private Image moleIMG;
    private Image moleHitIMG;
    private Image hammerIMG;
    private Image hitHammerIMG;

    public IMGmgmt() throws IOException {
        this.backgroundIMG = new ImageIcon("gameBackGround.jpg").getImage();
        this.moleIMG = new ImageIcon("Mole.png").getImage();
        this.moleHitIMG = new ImageIcon("HitMole.png").getImage();
        this.hammerIMG = new ImageIcon("hammer.png").getImage();
        this.hitHammerIMG = new ImageIcon("hitHammer.png").getImage();
    }

    public Image getBackgroundIMG() {
        return backgroundIMG;
    }

    public Image getMoleIMG() {
        return moleIMG;
    }

    public Image getMoleHitIMG() {
        return moleHitIMG;
    }

    public Image getHammerIMG() {
        return hammerIMG;
    }

    public Image getHitHammerIMG() {
        return hitHammerIMG;
    }
}
