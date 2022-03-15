package study;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split(){
        String[] actual = "1,2".split(",");
        assertThat(actual).containsExactly("1","2");
        actual = "1".split(",");
        assertThat(actual).contains("1");
    }

    @Test
    void substring(){
        String actual = "(1,2)";
        actual = actual.substring(actual.indexOf("(")+1, actual.indexOf(")")-1);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() test - assertThat ThrownBy를 활용")
    void charAt(){
        String actual = "abc";

        //기존 테스트 후, 위치값 벗어나는 경우 확인
        //charAt으로 추출하니까 외따옴표
        assertThat(actual.charAt(0)).isEqualTo('a');
        assertThat(actual.charAt(1)).isEqualTo('b');
        assertThat(actual.charAt(2)).isEqualTo('c');

        assertThatThrownBy( () -> {
            char val = actual.charAt(3);
            throw new Exception("범위 초과");
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("charAt() - Index out of bounds issue");
    }

    @Test
    @DisplayName("charAt() test - assertThat ExceptionOfType를 활용")
    void charAt2(){
        String actual = "abc";

        assertThat(actual.charAt(0)).isEqualTo('a');
        assertThat(actual.charAt(1)).isEqualTo('b');
        assertThat(actual.charAt(2)).isEqualTo('c');

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy( () -> {
                    char val = actual.charAt(3);
                    //컨펌 내용 : assert문에서 exception 발생라인 밑으로 평가안됨

                    System.out.println(val); //이 줄은 왜 들어가지?
                    throw new Exception("범위 초과");
                } ).withMessageMatching("charAt2() - Index out of bounds issue");
    }
}
