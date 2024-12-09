package pairmatching.controller;

import pairmatching.constant.SelectCommand;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairController {

    private final InputView inputView;
    private final OutputView outputView;

    public PairController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        SelectCommand command = processSelectInput();
    }

    private SelectCommand processSelectInput() {
        String selectInput = inputView.selectInput();
        return SelectCommand.checkCommand(selectInput);
    }
}
