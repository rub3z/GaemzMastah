package mancalaGame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mancalaGame.controller.MainViewController;

public class Mancala extends Application{
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mancalaGame/view/MainView.fxml"));
            Parent root = fxmlLoader.load();
            MainViewController mainViewController = fxmlLoader.getController();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setMaximized(true);
            primaryStage.show();
            mainViewController.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
