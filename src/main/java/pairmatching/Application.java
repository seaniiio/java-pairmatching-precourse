package pairmatching;

import pairmatching.config.AppConfig;
import pairmatching.controller.MainController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MainController mainController = appConfig.mainController();
        mainController.run();
    }
}
