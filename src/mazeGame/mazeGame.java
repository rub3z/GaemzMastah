package mazeGame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mazeGame.controller.MainViewController;

public class mazeGame extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mazeGame/view/MainView.fxml"));
            Parent root = fxmlLoader.load();
            MainViewController mainViewController = fxmlLoader.getController();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setMaximized(true);
            primaryStage.show();
            mainViewController.addKeyboardControl(primaryStage.getScene());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
