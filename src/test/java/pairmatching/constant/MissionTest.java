package pairmatching.constant;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MissionTest {

    @Test
    void 미션_찾기_예외_테스트() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Mission.find("페어매칭"))
                .withMessageContaining(ErrorMessage.MISSION_NOT_EXIST_ERROR.getErrorMessage());
    }

    @Test
    void 미션_찾기_테스트() {
        Assertions.assertThat(Mission.find("성능개선"))
                .isEqualTo(Mission.PERFORMANCE_IMPROVEMENT);
    }
}
