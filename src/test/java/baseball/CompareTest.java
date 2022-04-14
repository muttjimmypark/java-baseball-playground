package baseball;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CompareTest {
    List<Integer> regardComputerNumbers = Arrays.asList(1, 2, 3);
    Compare compare;

    @ParameterizedTest
    @CsvSource({"4,5,6,0", "1,7,8,1", "2,3,9,2", "2,3,1,3"})
    void existCount(int array1, int array2, int array3, int expectedValue) {
        compare = new Compare(regardComputerNumbers, Arrays.asList(array1, array2, array3));
        assertThat(compare.getExist()).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource({"4,5,6,0", "1,7,8,1", "4,2,3,2", "1,2,3,3", "2,3,1,0"})
    void strikeCount(int array1, int array2, int array3, int expectedValue) {
        compare = new Compare(regardComputerNumbers, Arrays.asList(array1, array2, array3));
        assertThat(compare.getStrike()).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource({"4,5,6,0", "7,8,1,1", "2,3,4,2", "2,3,1,3", "1,3,2,2", "1,2,3,0"})
    void ballCount(int array1, int array2, int array3, int expectedValue) {
        compare = new Compare(regardComputerNumbers, Arrays.asList(array1, array2, array3));
        assertThat(compare.getBall()).isEqualTo(expectedValue);
    }
}
