package chessGame;

import chessGame.controller.MainViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class chessGame extends Application {
   public static void main(String[] args) {
      launch(args);
   }

   @Override
   public void start(Stage primaryStage) {
      try {
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/chessGame/view/MainView.fxml"));
         Parent root = fxmlLoader.load();
         MainViewController controller = fxmlLoader.getController();
         Scene scene = new Scene(root);
         primaryStage.setScene(scene);
         primaryStage.setTitle("Chess");
         primaryStage.setMaximized(true);
         primaryStage.show();
         controller.start();
         controller.rePositionAllPieces(primaryStage);


      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
