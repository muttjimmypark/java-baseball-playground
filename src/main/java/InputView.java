import java.util.ArrayList;
import java.util.Scanner;

public class InputView {
    Scanner scanner;
    ArrayList<Integer> userInput = new ArrayList<Integer>();

    public void action() {
        System.out.print("숫자를 입력해 주세요 : ");
        scanner = new Scanner(System.in);
        int firstInput = scanner.nextInt();

        for (int i = 2; i >= 0; i--) {
            userInput.add(firstInput % 10);
            firstInput /= 10;
        }
    }

    public ArrayList<Integer> getUserInput() {
        return userInput;
    }
}
