package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    //Test Case 구현
    @Test
    @DisplayName("Set 요구사항 1")
    void size(){
        assertThat(numbers.size()).isEqualTo(3);
        // set은 중복과 순서가 없는 list(x) 모음(o, Collection)
    }

    @Test
    @DisplayName("Set 요구사항 2-1")
    void contains1(){
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("Set 요구사항 2-2 JUnit Parameterized Tests")
    void contains2(int element){
        // valueSource라는게 메소드 input에 알아서 전달 - ints attribute
        assertThat(numbers.contains(element)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    // 가상의 csv파일을 작성해서 2차원 인자를 집어넣는다는 식임
    @DisplayName("Set 요구사항 3 CsvSource")
    void contains3(int input, boolean expected){
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
