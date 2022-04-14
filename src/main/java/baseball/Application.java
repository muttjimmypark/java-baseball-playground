package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        while (true){
            playGame();
            if(UserInterface.endGameOrNew()) {
                break;
            }
        }
    }

    private static void playGame() {
        List<Integer> computerNumbers = Numbers.makeComputerNumbers();

        while (true) {
            List<Integer> playerNumbers = UserInterface.scanPlayerNumbers();
            Compare compare = new Compare(computerNumbers, playerNumbers);
            UserInterface.printBSMessage(compare.getBall(), compare.getStrike());

            if (compare.getStrike() == 3) {
                break;
            }
        }
    }
}
