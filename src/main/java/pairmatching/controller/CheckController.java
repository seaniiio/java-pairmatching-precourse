package pairmatching.controller;

import pairmatching.dto.PairsDto;
import pairmatching.service.PairService;
import pairmatching.util.InputProcessor;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class CheckController {

    private final InputView inputView;
    private final OutputView outputView;
    private final PairService pairService;

    public CheckController(final InputView inputView, final OutputView outputView, final PairService pairService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.pairService = pairService;
    }

    public void run() {
        InputProcessor.continueUntilNormalInput(this::processPairCheck, outputView::printErrorMessage);
    }

    private void processPairCheck() {
        outputView.printCourseLevelMission();
        String input = InputProcessor.continueUntilNormalInput(inputView::courseLevelMissionInput,
                outputView::printErrorMessage);
        PairsDto pairsDto = pairService.checkPair(input);
        outputView.printMatchResult(pairsDto);
    }
}
