package pairmatching.config;

import pairmatching.controller.PairController;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class AppConfig {

    public PairController pairController() {
        return new PairController(inputView(), outputView());
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }
}
