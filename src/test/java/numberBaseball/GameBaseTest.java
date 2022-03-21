package numberBaseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class GameBaseTest {
    public static GameBase gameBase;

    @BeforeEach
    void setUp() {
        gameBase = new GameBase();
    }

    @Test
    @DisplayName("Test : NumberBaseball/GameBase.java/setOriginNumber")
    void setOriginNumberTest() {
        List<Integer> actual;

        gameBase.setOriginNumber();
        actual = gameBase.originNumber;

        for (int i = 0; i < 3; i++) {
            assertThat(actual.get(i)).isBetween(0, 9);
        }
        assertThat(actual.get(0))
                .isNotEqualTo(actual.get(1))
                .isNotEqualTo(actual.get(2));
        assertThat(actual.get(1))
                .isNotEqualTo(actual.get(2));
    }

    @AfterEach
    void tearDown() {
        gameBase = null;
    }
}