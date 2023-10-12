public class gameSetting {
    private int width,height;
    private int startButtonWidth, startButtonheight;
    private int moleWidth,moleHeight;
    gameSetting(){
        this.width = 1920;
        this.height = 1080;
        this.startButtonWidth = 300;
        this.startButtonheight = 150;
        this.moleHeight = 300;
        this.moleWidth = 200;

    }
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getStartButtonWidth() {
        return startButtonWidth;
    }

    public void setStartButtonWidth(int startButtonWidth) {
        this.startButtonWidth = startButtonWidth;
    }

    public int getStartButtonheight() {
        return startButtonheight;
    }

    public void setStartButtonheight(int startButtonheight) {
        this.startButtonheight = startButtonheight;
    }

    public int getMoleWidth() {
        return moleWidth;
    }

    public void setMoleWidth(int moleWidth) {
        this.moleWidth = moleWidth;
    }

    public int getMoleHeight() {
        return moleHeight;
    }

    public void setMoleHeight(int moleHeight) {
        this.moleHeight = moleHeight;
    }
}
