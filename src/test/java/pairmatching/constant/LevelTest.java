package pairmatching.constant;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LevelTest {

    @Test
    void 레벨_찾기_예외_테스트() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Level.find("레벨0"))
                .withMessageContaining(ErrorMessage.LEVEL_NOT_EXIST_ERROR.getErrorMessage());
    }

    @Test
    void 레벨_찾기_테스트() {
        Assertions.assertThat(Level.find("레벨2"))
                .isEqualTo(Level.LEVEL2);
    }
}
