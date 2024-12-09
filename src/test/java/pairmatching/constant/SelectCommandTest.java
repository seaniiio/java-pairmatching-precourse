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

    @Test
    void 기능_선택_예외_테스트() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> SelectCommand.checkCommand("1번"))
                .withMessageContaining(ErrorMessage.COMMAND_NOT_EXIST_ERROR.getErrorMessage());
    }
}
