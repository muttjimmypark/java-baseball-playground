package baseball;

import java.util.List;

public class Compare {
    List<Integer> computerNumbers;
    List<Integer> playerNumbers;
    private int exist = 0;
    private int strike = 0;

    public Compare(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        this.computerNumbers = computerNumbers;
        this.playerNumbers = playerNumbers;
        existCount();
        strikeCount();
    }

    public void existCount() {
        for (int i = 0; i < 3; i++) {
            if (computerNumbers.contains(playerNumbers.get(i))) {
                exist++;
            }
        }
    }

    public void strikeCount() {
        for (int i = 0; i < 3; i++) {
            if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
                strike++;
            }
        }
    }

    public int getExist() {
        return exist;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return exist - strike;
    }
}
