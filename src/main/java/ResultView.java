import java.util.Scanner;

public class ResultView {
    Scanner scanner;
    boolean continueFlag;

    public void action(int ball, int strike) {
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    public void gameOver() {
        scanner = new Scanner(System.in);
        continueFlag = false;

        System.out.println("3 스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        if (scanner.nextInt() == 1)
            continueFlag = true;
    }

    public boolean getContinueFlag() {
        return continueFlag;
    }
}
