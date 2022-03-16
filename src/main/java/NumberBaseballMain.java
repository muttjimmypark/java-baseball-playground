public class NumberBaseballMain {
    public static void main(String[] args){
        InputView inputView;
        GameBoard gameBoard;

        gameBoard = new GameBoard();
        gameBoard.setOriginNumber();

        while() {
            inputView = new InputView();
            inputView.action();

            gameBoard.setUserNumber(inputView.getPlayersInput());

        }
    }
}
