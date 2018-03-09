package mazeGame;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import mazeGame.controller.MainViewController;

public class Maze {
   private static Maze mazeInstance;

   public Maze() {
      if (mazeInstance == null) {
         mazeInstance = this;
         start();
      }
   }

   private void start() {
      try {
         Stage stage = new Stage();
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mazeGame/view/MainView.fxml"));
         Parent root = fxmlLoader.load();
         MainViewController mainViewController = fxmlLoader.getController();
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.setMaximized(true);
         stage.setTitle("Maze");
         stage.show();
         mainViewController.addKeyboardControl(stage.getScene());
         stage.addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, event -> {
            mazeInstance = null;
         });
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

}
