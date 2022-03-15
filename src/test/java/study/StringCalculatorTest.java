package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    public static StringCalculator stringCalculator;

    @BeforeEach
    void setUp(){
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("Test - blankSplit")
    void blankSplit(){
        String[] actual = stringCalculator.blankSplit("2 + 3");
        assertThat(actual).containsExactly("2","+","3");
    }

    //작성중
    @ParameterizedTest
    @CsvSource({""2",2",""3",3",""4",4"})
    @DisplayName("Test - stringToInteger")
    void stringToInteger(String input1, int input2){
        assertThat()
    }
}
