import java.util.ArrayList;

public class GameCycle {
    int ball;
    int strike;
    ArrayList<Integer> userNumber = new ArrayList<>();

    //InputView -> GameBase -> GameCycle
    public void setUserNumber(ArrayList<Integer> userNumber) {
        this.userNumber.add(userNumber.get(2));
        this.userNumber.add(userNumber.get(1));
        this.userNumber.add(userNumber.get(0));

    }

    public void countBallStrike(ArrayList<Integer> originNumber) {
        if (originNumber.get(0).equals(userNumber.get(0)))
            strike++;
        if (originNumber.get(1).equals(userNumber.get(1)))
            strike++;
        if (originNumber.get(2).equals(userNumber.get(2)))
            strike++;

        if (originNumber.contains(userNumber.get(0)))
            ball++;
        if (originNumber.contains(userNumber.get(1)))
            ball++;
        if (originNumber.contains(userNumber.get(2)))
            ball++;

        ball -= strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public void clearCount() {
        ball = 0;
        strike = 0;
        this.userNumber.clear();
    }
}
