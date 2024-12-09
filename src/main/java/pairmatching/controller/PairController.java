package pairmatching.controller;

import pairmatching.constant.SelectCommand;
import pairmatching.service.PairService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairController {

    private final InputView inputView;
    private final OutputView outputView;
    private final PairService pairService;

    public PairController(final InputView inputView, final OutputView outputView, final PairService pairService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.pairService = pairService;
    }

    public void run() {
        SelectCommand command = processSelectInput();
        processByCommand(command);
    }

    private SelectCommand processSelectInput() {
        String selectInput = inputView.selectInput();
        return SelectCommand.checkCommand(selectInput);
    }

    private void processByCommand(SelectCommand command) {
        if (command.equals(SelectCommand.PAIR_MATCHING)) {
            processPairMatching();
            return;
        }

    }

    private void processPairMatching() {
        outputView.printCourseLevelMission();
    }
}
