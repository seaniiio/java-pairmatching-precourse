package pairmatching.config;

import pairmatching.controller.PairController;
import pairmatching.service.PairService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class AppConfig {

    public PairController pairController() {
        return new PairController(inputView(), outputView(), pairService());
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private PairService pairService() {
        return new PairService();
    }
}
