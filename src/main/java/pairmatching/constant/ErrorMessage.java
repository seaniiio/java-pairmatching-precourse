package pairmatching.constant;

public enum ErrorMessage {
    COMMAND_NOT_EXIST_ERROR("선택한 기능은 존재하지 않습니다."),
    INPUT_FORMAT_ERROR("올바르지 않은 입력입니다. 다시 입력해 주세요."),
    MISSION_NOT_EXIST_ERROR("미션이 존재하지 않습니다."),
    LEVEL_NOT_EXIST_ERROR("레벨이 존재하지 않습니다."),
    COURSE_NOT_EXIST_ERROR("과정이 존재하지 않습니다."),
    MATCHING_FAIL_ERROR("페어 매칭에 실패했습니다."),
    YES_OR_NO_INPUT_ERROR("네 / 아니오만 입력해주세요.");

    private static final String PREFIX = "[ERROR] ";
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return PREFIX + errorMessage;
    }
}
