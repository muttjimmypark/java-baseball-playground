package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {
    @Test
    @DisplayName("검증 숫자가 3자리 인지 테스트")
    void isThreeNumbers_verifyNumbers() {
        assertThat(Numbers.verifyNumbers(Arrays.asList(1)))
                .isFalse();
        assertThat(Numbers.verifyNumbers(Arrays.asList(1, 2)))
                .isFalse();
        assertThat(Numbers.verifyNumbers(Arrays.asList(1, 2, 3)))
                .isTrue();
        assertThat(Numbers.verifyNumbers(Arrays.asList(1, 2, 3, 4)))
                .isFalse();
    }

    @Test
    @DisplayName("검증 숫자가 1~9 인지 테스트")
    void numbersRange_verifyNumbers() {
        assertThat(Numbers.verifyNumbers(Arrays.asList(1, 2, 0)))
                .isFalse();
        assertThat(Numbers.verifyNumbers(Arrays.asList(8, 9, 10)))
                .isFalse();
        assertThat(Numbers.verifyNumbers(Arrays.asList(3, 4, 5)))
                .isTrue();
    }

    @Test
    @DisplayName("검증 숫자에 중복이 없는지 테스트")
    void differentEachElements_verifyNumbers() {
        assertThat(Numbers.verifyNumbers(Arrays.asList(1, 1, 2)))
                .isFalse();
        assertThat(Numbers.verifyNumbers(Arrays.asList(6, 7, 8)))
                .isTrue();
    }

    @Test
    @DisplayName("makeComputerNumbers도 verifyNumbers를 통과하는지 테스트")
    void verifying_makeComputerNumbers() {
        assertThat(Numbers.verifyNumbers(Numbers.makeComputerNumbers()))
                .isTrue();
    }
}
