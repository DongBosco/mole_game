public class gameScore {
    private int score;
    private int userType ;
    gameScore(){
        this.score= 0;
        this.userType=1;
    }
    gameScore(int player){
        this.score = 0;
        this.userType=player;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
