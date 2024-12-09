package pairmatching.constant;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SelectCommandTest {

    @Test
    void 기능_선택_테스트() {
        Assertions.assertThat(SelectCommand.checkCommand("3"))
                .isEqualTo(SelectCommand.PAIR_INITIALIZATION);
    }
}
