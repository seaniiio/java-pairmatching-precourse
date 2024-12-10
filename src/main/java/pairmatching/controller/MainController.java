package pairmatching.controller;

import pairmatching.constant.SelectCommand;
import pairmatching.dto.PairsDto;
import pairmatching.util.InputProcessor;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MainController {

    private final MatchController matchController;
    private final CheckController checkController;
    private final InitializeController initializeController;
    private final InputView inputView;
    private final OutputView outputView;

    public MainController(final MatchController matchController,
                          final CheckController checkController,
                          final InitializeController initializeController,
                          final InputView inputView,
                          final OutputView outputView) {
        this.matchController = matchController;
        this.checkController = checkController;
        this.initializeController = initializeController;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        SelectCommand command = InputProcessor.continueUntilNormalInput(this::processSelectInput, outputView::printErrorMessage);
        while (true) {
            if (command.equals(SelectCommand.PAIR_MATCHING)) {
                matchController.run();
            }
            if (command.equals(SelectCommand.PAIR_CHECK)) {
                checkController.run();
            }
            if (command.equals(SelectCommand.PAIR_INITIALIZATION)) {
                initializeController.run();
            }
            if (command.equals(SelectCommand.QUIT)) {
                break;
            }
        }
    }

    private SelectCommand processSelectInput() {
        String selectInput = inputView.selectInput();
        return SelectCommand.checkCommand(selectInput);
    }
}
