import java.util.ArrayList;
import java.util.Random;

public class GameBase {
    Random random;
    ArrayList<Integer> originNumber = new ArrayList<>();
    GameCycle gameCycle = new GameCycle();
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    public void setOriginNumber() {
        random = new Random();
        random.setSeed(System.currentTimeMillis());

        originNumber.add(random.nextInt(9));

        int tmp = random.nextInt(9);
        if (!originNumber.contains(tmp))
            originNumber.add(tmp);

        tmp = random.nextInt(9);
        if (!originNumber.contains(tmp))
            originNumber.add(tmp);

    }

    public void action() {
        while (true) {
            inputView.action();
            gameCycle.setUserNumber(inputView.getUserInput());

            gameCycle.countBallStrike(originNumber);
            if (gameCycle.getStrike() == 3)
                break;
            resultView.action(gameCycle.getBall(), gameCycle.getStrike());

            inputView.clearInput();
            gameCycle.clearCount();
        }
    }
}
