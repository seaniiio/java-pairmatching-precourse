package pairmatching.controller;

import pairmatching.constant.SelectCommand;
import pairmatching.service.PairService;
import pairmatching.util.InputProcessor;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MainController {

    private final MatchController matchController;
    private final CheckController checkController;
    private final InitializeController initializeController;
    private final InputView inputView;
    private final OutputView outputView;
    private  final PairService pairService;

    public MainController(final MatchController matchController,
                          final CheckController checkController,
                          final InitializeController initializeController,
                          final InputView inputView,
                          final OutputView outputView,
                          final PairService pairService) {
        this.matchController = matchController;
        this.checkController = checkController;
        this.initializeController = initializeController;
        this.inputView = inputView;
        this.outputView = outputView;
        this.pairService = pairService;
    }

    public void run() {
        pairService.initializeCrew();
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
            command = InputProcessor.continueUntilNormalInput(this::processSelectInput, outputView::printErrorMessage);
        }
    }

    private SelectCommand processSelectInput() {
        String selectInput = inputView.selectInput();
        return SelectCommand.checkCommand(selectInput);
    }
}
