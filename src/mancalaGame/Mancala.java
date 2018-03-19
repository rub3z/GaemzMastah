package mancalaGame;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import mancalaGame.controller.MainViewController;

public class Mancala {
   private static Mancala mancalaInstance;

   public Mancala() {
      System.out.println(mancalaInstance);
      if (mancalaInstance == null) {
         mancalaInstance = this;
         start();
      }
   }

   public void start() {
      try {
         Stage stage = new Stage();
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mancalaGame/view/MainView.fxml"));
         Parent root = fxmlLoader.load();
         MainViewController mainViewController = fxmlLoader.getController();
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.setTitle("Mancala");
         stage.setMaximized(true);
         stage.show();
         mainViewController.start();
         stage.addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, event -> {
            mancalaInstance = null;
         });
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
