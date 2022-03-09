package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
    void charAt(){
        String actual = "abc";

        //기존 테스트 후, 위치값 벗어나는 경우 확인
        assertThat(actual.charAt(0)).isEqualTo('a');
        assertThat(actual.charAt(1)).isEqualTo('b');
        assertThat(actual.charAt(2)).isEqualTo('c');

        assertThatThrownBy( () -> {
            char val = actual.charAt(3);
            throw new Exception("범위 초과");
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String");
    }
}
