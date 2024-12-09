package pairmatching.constant;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CourseTest {

    @Test
    void 과정_찾기_예외_테스트() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Course.find("안드로이드"))
                .withMessageContaining(ErrorMessage.COURSE_NOT_EXIST_ERROR.getErrorMessage());
    }

    @Test
    void 과정_찾기_테스트() {
        Assertions.assertThat(Course.find("백엔드"))
                .isEqualTo(Course.BACKEND);
    }
}
