package pairmatching.config;

import pairmatching.controller.CheckController;
import pairmatching.controller.InitializeController;
import pairmatching.controller.MainController;
import pairmatching.controller.MatchController;
import pairmatching.domain.PairMaker;
import pairmatching.service.PairService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class AppConfig {

    public MainController mainController() {
        return new MainController(matchController(), checkController(), initializeController(), inputView(), outputView());
    }

    private MatchController matchController() {
        return new MatchController(inputView(), outputView(), pairService());
    }

    private CheckController checkController() {
        return new CheckController(inputView(), outputView(), pairService());
    }

    private InitializeController initializeController() {
        return new InitializeController(outputView(), pairService());
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private PairService pairService() {
        return new PairService(pairMaker());
    }

    private PairMaker pairMaker() {
        return new PairMaker();
    }
}
