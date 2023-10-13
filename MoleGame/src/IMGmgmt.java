import javax.swing.*;
import java.awt.*;

public class IMGmgmt extends JFrame {
    private Image backgroundIMG ;
    private Image moleIMG;
    private Image moleHitIMG;
    private Image hammerIMG;
    private Image hitHammerIMG;
    private Image introBackgrounIMG;

    public IMGmgmt() {
        this.backgroundIMG = new ImageIcon(getClass().getResource("/image/gameBackGround.jpg")).getImage();
        this.moleIMG = new ImageIcon(getClass().getResource("/image/Mole.png")).getImage();
        this.moleHitIMG = new ImageIcon(getClass().getResource("/image/HitMole.png")).getImage();
        this.hammerIMG = new ImageIcon(getClass().getResource("/image/hammer.png")).getImage();
        this.hitHammerIMG = new ImageIcon(getClass().getResource("/image/hitHammer.png")).getImage();
        this.introBackgrounIMG = new ImageIcon(getClass().getResource("/image/mole_intro.jpg")).getImage();

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

    public Image getIntroBackgrounIMG() {
        return introBackgrounIMG;
    }

}
