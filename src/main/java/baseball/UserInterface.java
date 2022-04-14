package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    public static List<Integer> scanPlayerNumbers() {
        List<Integer> playerNumbers;
        boolean requestFlag;
        do {
            playerNumbers = loopForScanPlayerNumbers();
            requestFlag = Numbers.verifyNumbers(playerNumbers);
            if (!requestFlag) {
                System.out.println("잘못된 입력입니다.");
            }
        } while (!requestFlag);

        return playerNumbers;
    }

    private static List<Integer> loopForScanPlayerNumbers() {
        System.out.print("숫자를 입력해 주세요 : ");
        String playerInput = new Scanner(System.in).next();

        List<Integer> playerNumbers = new ArrayList<>();
        for (String number : playerInput.split("")) {
            playerNumbers.add(Integer.valueOf(number));
        }

        return playerNumbers;
    }

    public static void printBSMessage(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return;
        }
        if (strike == 0) {
            System.out.println(ball + "볼");
            return;
        }
        if (ball == 0) {
            System.out.println(strike + "스트라이크");
            return;
        }

        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    public static boolean endGameOrNew() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        while (true) {
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 : ");
            int oneTwo = new Scanner(System.in).nextInt();
            if (oneTwo == 2) {
                //endGame is true
                return true;
            }
            if (oneTwo == 1) {
                //newGame is false
                return false;
            }
            System.out.println("잘못된 입력입니다.");
        }
    }
}
