package baseball;

import java.util.List;
import java.util.stream.IntStream;

public class Compare {
    private List<Integer> computerNumbers;
    private List<Integer> playerNumbers;
    private int exist = 0;
    private int strike = 0;

    public Compare(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        this.computerNumbers = computerNumbers;
        this.playerNumbers = playerNumbers;
        existCount();
        strikeCount();
    }

    public void existCount() {
//        for (int i = 0; i < 3; i++) {
//            if (computerNumbers.contains(playerNumbers.get(i))) {
//                exist++;
//            }
//        }

        exist = (int) playerNumbers.stream()
                .filter(playerNumber -> computerNumbers.contains(playerNumber))
                .count();

    }

    public void strikeCount() {
//        for (int i = 0; i < 3; i++) {
//            if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
//                strike++;
//            }
//        }

        strike = (int) IntStream.range(0, 3)
                .filter(i -> (computerNumbers.get(i).equals(playerNumbers.get(i))))
                .count();
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
