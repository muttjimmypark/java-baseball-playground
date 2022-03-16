package study;

import org.junit.jupiter.api.AfterEach;
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

    @ParameterizedTest
    @CsvSource({""2",2",""3",3",""4",4"})
    @DisplayName("Test - stringToInteger")
    void stringToInteger(String input1, int input2){
        assertThat(stringCalculator.stringToInteger(input1)).isEqualTo(input2);
    }

    @ParameterizedTest
    @CsvSource({"2,"+",3,5","3,"-",2,1","3,"*",4,12","4,"/",2,2"})
    @DisplayName("Test - arithmetic2Elements")
    void stringToInteger(int input1, String input2, int input3, int input4){
        assertThat(stringCalculator.arithmetic2Elements(input1,input2,input3)).isEqualTo(input4);
    }

    @Test
    @DisplayName("Test - arithmeticLogic")
    void arithmeticLogic(){
        //앞서 테스트로 검증하된 메서드가 다른 메서드의 테스트에 활용되어도 괜찮은가?
        String[] actual = stringCalculator.blankSplit("2 + 3 * 4 / 2");
        assertThat(stringCalculator.arithmeticLogic(actual)).isEqualTo(10);
    }

    @AfterEach
    void tearDown(){
        stringCalculator = null;
    }
}
