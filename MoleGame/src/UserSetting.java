import java.util.Random;

public class UserSetting {
    private int perriodMole;
    private int maxMoleNum;
    private int goalScore;
    private int userLevel;
    UserSetting(){
        this.perriodMole = 1;
        this.maxMoleNum = 1;
        this.goalScore = 1;
        this.userLevel = 0;
    }

    public boolean SETTING(){
        if(this.userLevel ==1){
            this.perriodMole =1000;
            this.maxMoleNum =50;
            this.goalScore = 20;
            System.out.println("현재 1레벨 / easy");
            return true;
        } else if (this.userLevel == 2) {
            this.perriodMole =500;
            this.maxMoleNum =100;
            this.goalScore = 80;
            System.out.println("현재 2레벨 / hard");
            return true;
        }
        else {
            System.out.println("userLevel이 설정되지 않았습니다.");
            return false;
        }
    }
    public  int getUserLevel(){
        return userLevel;
    }
    public void setUserLevel(int level){
        this.userLevel = level;
    }
    public int getPerriodMole() {
        return perriodMole;
    }

    public void setPerriodMole(int perriodMole) {
        this.perriodMole = perriodMole;
    }

    public int getMaxMoleNum() {
        return maxMoleNum;
    }

    public void setMaxMoleNum(int maxMoleNum) {
        this.maxMoleNum = maxMoleNum;
    }

    public int getGoalScore() {
        return goalScore;
    }

    public void setGoalScore(int goalScore) {
        this.goalScore = goalScore;
    }
}
