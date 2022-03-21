package numberBaseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class GameCycleTest {
    public static GameCycle gameCycle;

    @BeforeEach
    void setUp() {
        gameCycle = new GameCycle();
    }

    @Test
    @DisplayName("Test : NumberBaseball/GameCycle.java/setUserNumber")
    void setUserNumberTest() {
        List<Integer> actual = new ArrayList<>();
        actual.add(1);
        actual.add(3);
        actual.add(5);

        gameCycle.setUserNumber(actual);

        assertThat(gameCycle.userNumber.size()).isEqualTo(3);
        for (int i = 0; i < 3; i++) {
            assertThat(actual.get(i))
                    .isEqualTo(gameCycle.userNumber.get(i));
        }
    }

    @Test
    @DisplayName("Test : NumberBaseball/GameCycle.java/countBallStrike")
    void countBallStrikeTest() {
        //테스트가 독립적이기 위해 직접 초기화 및 값 설정
        //jUnit에서 필요없도록 설계되어있지 않을까? - BeforeEach, 각 Test들 사이 구동 관계
        gameCycle.ball = 0;
        gameCycle.strike = 0;
        gameCycle.userNumber.clear();

        gameCycle.userNumber.add(1);
        gameCycle.userNumber.add(3);
        gameCycle.userNumber.add(5);

        //jUnit에서 각 Test의 독립성을 보장한다면
        List<Integer> actual = new ArrayList<>();
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        actual.add(random.nextInt(9));
        int tmp = random.nextInt(9);
        if (!actual.contains(tmp))
            actual.add(tmp);
        tmp = random.nextInt(9);
        if (!actual.contains(tmp))
            actual.add(tmp);
        //위 파트도 gamebase.setOriginNumber 활용가능
        gameCycle.countBallStrike(actual);
        assertThat(gameCycle.ball).isBetween(0,3);
        assertThat(gameCycle.strike).isBetween(0,3);

        actual.clear();
        actual.add(1);
        actual.add(2);
        actual.add(3);
        gameCycle.countBallStrike(actual);
        assertThat(gameCycle.ball).isEqualTo(1);
        assertThat(gameCycle.strike).isEqualTo(1);

        actual.clear();
        actual.add(1);
        actual.add(3);
        actual.add(5);
        gameCycle.countBallStrike(actual);
        assertThat(gameCycle.ball).isEqualTo(0);
        assertThat(gameCycle.strike).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("Test : NumberBaseball/GameCycle.java/clearCount")
    void clearCountTest(int element) {
        gameCycle.ball = element;
        gameCycle.strike = element;
        gameCycle.userNumber.add(element);

        gameCycle.clearCount();

        assertThat(gameCycle.ball).isEqualTo(0);
        assertThat(gameCycle.strike).isEqualTo(0);
        assertThat(gameCycle.userNumber).isNull();
    }

    @AfterEach
    void tearDown(){
        gameCycle = null;
    }
}
