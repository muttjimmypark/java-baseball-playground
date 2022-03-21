import java.util.ArrayList;
import java.util.Scanner;

public class InputView {
    Scanner scanner;
    ArrayList<Integer> userInput = new ArrayList<>();

    public void action() {
        System.out.print("숫자를 입력해 주세요 : ");
        scanner = new Scanner(System.in);
        int firstInput = scanner.nextInt();

        for (int i = 0; i < 3; i++) {
            userInput.add(firstInput % 10);
            firstInput /= 10;
        }
    }

    public ArrayList<Integer> getUserInput() {
        return userInput;
    }

    public void clearInput() {
        this.userInput.clear();
    }
}
