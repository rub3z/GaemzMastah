package launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import launcher.model.ProgramManager;

public class Launcher extends Application {

    public static void main(String[] args) {
        new ProgramManager("src/Launcher/resources/Database.xml").readDataFromFile();
        launch(args);


    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/launcher/view/MainView.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setMaximized(true);
            primaryStage.setTitle("Launcher");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
