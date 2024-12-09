package pairmatching.constant;

public enum ErrorMessage {
    COMMAND_NOT_EXIST_ERROR("선택한 기능은 존재하지 않습니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return PREFIX + errorMessage;
    }
}
