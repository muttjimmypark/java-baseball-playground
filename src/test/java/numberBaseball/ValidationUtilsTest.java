package numberBaseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilsTest {
    @Test
    @DisplayName("숫자가 1~9 범위인지 테스트")
    void numberRange() {
        assertThat(ValidationUtils.numberRange(9)).isTrue();
        assertThat(ValidationUtils.numberRange(1)).isTrue();
        assertThat(ValidationUtils.numberRange(0)).isFalse();
        assertThat(ValidationUtils.numberRange(10)).isFalse();
    }

    @Test
    @DisplayName("숫자 중복 여부 - 입력받을 숫자가 기존 입력받은 숫자들과 다른지")
    void numberDifferent() {
        List<Integer> actual = new ArrayList<>();
        assertThat(ValidationUtils.numberDifferent(1, actual)).isTrue();
        assertThat(ValidationUtils.numberDifferent(2, actual)).isTrue();

        actual.add(1);
        assertThat(ValidationUtils.numberDifferent(1, actual)).isFalse();
        assertThat(ValidationUtils.numberDifferent(2, actual)).isTrue();

        actual.add(2);
        assertThat(ValidationUtils.numberDifferent(1, actual)).isFalse();
        assertThat(ValidationUtils.numberDifferent(2, actual)).isFalse();
    }

    @Test
    @DisplayName("입력받은 숫자가 3개인지")
    void threeNumbers() {
        List<Integer> actual = new ArrayList<>();
        assertThat(ValidationUtils.threeNumbers(actual)).isFalse();

        actual.add(1);
        assertThat(ValidationUtils.threeNumbers(actual)).isFalse();

        actual.add(2);
        assertThat(ValidationUtils.threeNumbers(actual)).isFalse();

        actual.add(3);
        assertThat(ValidationUtils.threeNumbers(actual)).isTrue();

        actual.add(4);
        assertThat(ValidationUtils.threeNumbers(actual)).isFalse();
    }
}
