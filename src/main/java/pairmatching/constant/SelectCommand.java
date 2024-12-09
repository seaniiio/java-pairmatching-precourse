package pairmatching.constant;

public enum SelectCommand {

    PAIR_MATCHING("1"),
    PAIR_CHECK("2"),
    PAIR_INITIALIZATION("3"),
    QUIT("Q");

    private final String command;

    private SelectCommand(String command) {
        this.command = command;
    }

    public static SelectCommand checkCommand(String selectInput) {
        for (SelectCommand command : SelectCommand.values()) {
            if (command.command.equals(selectInput)) {
                return command;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.COMMAND_NOT_EXIST_ERROR.getErrorMessage());
    }

    public boolean equals(SelectCommand command) {
        return this.command.equals(command.command);
    }
}
