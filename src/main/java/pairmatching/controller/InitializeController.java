package pairmatching.controller;

import pairmatching.service.PairService;
import pairmatching.view.OutputView;

public class InitializeController {

    private final OutputView outputView;
    private final PairService pairService;

    public InitializeController(final OutputView outputView, final PairService pairService) {
        this.outputView = outputView;
        this.pairService = pairService;
    }

    public void run() {
        pairService.initializePairs();
        outputView.printInitializeMessage();
    }
}
