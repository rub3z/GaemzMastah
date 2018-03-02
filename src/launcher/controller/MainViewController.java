package launcher.controller;

import javafx.fxml.FXML;
import launcher.model.Program;
import launcher.model.ProgramManager;

import java.util.ArrayList;

public class MainViewController {
    @FXML
    TopLogoController topLogoController;
    @FXML
    BottomLogoController bottomLogoController;
    @FXML
    GameListController gameListController;
    ProgramManager programManager;

    public MainViewController() {
        programManager = new ProgramManager("src/launcher/resources/Database.xml");
    }

    @FXML
    public void initialize() {
        gameListController.initializeParentController(this);
        gameListController.addAppsToView(new ArrayList<Program>(programManager.getAppList()));
    }
}
