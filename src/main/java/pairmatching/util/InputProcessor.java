package pairmatching.util;

import java.util.function.Consumer;
import java.util.function.Supplier;
import pairmatching.constant.SelectCommand;

public class InputProcessor {

    public static void continueUntilNormalInput(Runnable processInput, Consumer<String> processIfErrorOccur) {
        while (true) {
            try {
                processInput.run();
                break;
            } catch (IllegalArgumentException e) {
                processIfErrorOccur.accept(e.getMessage());
            }
        }
    }

    public static <T> T continueUntilNormalInput(Supplier<T> processInput, Consumer<String> processIfErrorOccur) {
        while (true) {
            try {
                return processInput.get();
            } catch (IllegalArgumentException e) {
                processIfErrorOccur.accept(e.getMessage());
            }
        }
    }

    public static void continueUntilQuit(Supplier<SelectCommand> processInput) {
        while (true) {
            if (processInput.get().equals(SelectCommand.QUIT)) {
                break;
            }
        }
    }
}
