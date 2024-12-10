package pairmatching.controller;

import pairmatching.constant.YesNoCommand;
import pairmatching.dto.PairsDto;
import pairmatching.service.PairService;
import pairmatching.util.InputProcessor;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchController {

    private final InputView inputView;
    private final OutputView outputView;
    private final PairService pairService;

    public MatchController(final InputView inputView, final OutputView outputView, final PairService pairService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.pairService = pairService;
    }

    public void run() {
        InputProcessor.continueUntilNormalInput(this::processPairMatching, outputView::printErrorMessage);
    }

    private void processPairMatching() {
        outputView.printCourseLevelMission();
        String input = InputProcessor.continueUntilNormalInput(inputView::courseLevelMissionInput,
                outputView::printErrorMessage);

        if (pairService.checkPairExist(input)) {
            processExistingPairProcess(input);
            return;
        }

        PairsDto pairsDto = pairService.pairMatching(input);
        outputView.printMatchResult(pairsDto);
    }

    private void processExistingPairProcess(String input) {
        // 이미 매칭 정보가 존재하는 경우, 재매칭 or 과정레벨미션 다시선택
        YesNoCommand yesOrNoInput = InputProcessor.continueUntilNormalInput(this::processYesOrNoInputProcess, outputView::printErrorMessage);
        if (yesOrNoInput.equals(YesNoCommand.YES)) {
            PairsDto pairsDto = pairService.rematch(input);
            outputView.printMatchResult(pairsDto);
        }

        if (yesOrNoInput.equals(YesNoCommand.NO)) {
            processPairMatching();
        }
    }

    private YesNoCommand processYesOrNoInputProcess() {
        String yesOrNoInput = inputView.rematchInput();
        return YesNoCommand.find(yesOrNoInput);
    }
}
