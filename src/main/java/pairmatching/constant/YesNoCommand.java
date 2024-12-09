package pairmatching.constant;

public enum YesNoCommand {

    YES("네"),
    NO("아니오");

    private final String command;

    YesNoCommand(String command) {
        this.command = command;
    }

    public static YesNoCommand find(String input) {
        for (YesNoCommand command : YesNoCommand.values()) {
            if (command.command.equals(input)) {
                return command;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.YES_OR_NO_INPUT_ERROR.getErrorMessage());
    }
}
