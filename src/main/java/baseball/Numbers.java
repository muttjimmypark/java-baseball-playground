package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Numbers {
    public static boolean verifyNumbers(List<Integer> inputNumbers) {
        if (inputNumbers.size() != 3) {
            return false;
        }

        if (Collections.min(inputNumbers) < 1 || Collections.max(inputNumbers) > 9) {
            return false;
        }

        if (inputNumbers.size() != inputNumbers.stream().distinct().count()) {
            return false;
        }

        return true;
    }

    public static List<Integer> makeComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();

        while (computerNumbers.size() < 3) {
            int createdNumber = new Random().nextInt(9) + 1;
            if (!computerNumbers.contains(createdNumber)) {
                computerNumbers.add(createdNumber);
            }
        }

//        System.out.println(computerNumbers);
        return computerNumbers;
    }
}
