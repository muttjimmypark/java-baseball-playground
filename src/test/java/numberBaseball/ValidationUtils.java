package numberBaseball;

import java.util.List;

public class ValidationUtils {
    public static boolean numberRange(int number) {
        return number <= 9 && number >= 1;
    }

    public static boolean numberDifferent(int input, List<Integer> numbers) {
        return !numbers.contains(input);
    }

    public static boolean threeNumbers(List<Integer> actual) {
        return actual.size() == 3;
    }
}
