package numberBaseball;

public class NumberBaseballMain {
    public static void main(String[] args) {
        GameBase gameBase;
        ResultView resultView = new ResultView();

        do {
            gameBase = new GameBase();
            gameBase.setOriginNumber();
            gameBase.action();
            resultView.gameOver();
        } while (resultView.getContinueFlag());
    }
}
