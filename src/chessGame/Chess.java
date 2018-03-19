package chessGame;

import chessGame.controller.MainViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Chess {
   private static Chess chessInstance;

   public Chess() {
      if (chessInstance == null) {
         chessInstance = this;
         start();
      }
   }

   public void start() {
      try {
         Stage stage = new Stage();
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/chessGame/view/MainView.fxml"));
         Parent root = fxmlLoader.load();
         MainViewController controller = fxmlLoader.getController();
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.setTitle("Chess");
         stage.setMaximized(true);
         stage.show();
         controller.start();
         controller.rePositionAllPieces(stage);
         stage.addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, event -> {
            chessInstance = null;
         });


      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
