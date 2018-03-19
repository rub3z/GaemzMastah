package concentrationGame;

import concentrationGame.controller.GameViewController;
import concentrationGame.controller.MainViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Concentration extends Application {

   /**
    * Launch your program
    *
    * @param args
    */
   public static void main(String[] args) {
      launch(args);
   }

   /**
    * The main entry point for all JavaFX applications.
    * The start method is called after the init method has returned,
    * and after the system is ready for the application to begin running.
    * <p>
    * <p>
    * NOTE: This method is called on the JavaFX Application Thread.
    * </p>
    *
    * @param primaryStage the primary stage for this application, onto which
    *                     the application scene can be set. The primary stage will be embedded in
    *                     the browser if the application was launched as an applet.
    *                     Applications may create other stages, if needed, but they will not be
    *                     primary stages and will not be embedded in the browser.
    */
   @Override
   public void start(Stage primaryStage) {
      try {
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/concentrationGame/view/MainView.fxml"));
         Parent root = fxmlLoader.load();
         MainViewController gameViewController = fxmlLoader.getController();
         Scene scene = new Scene(root);
         primaryStage.setScene(scene);
         primaryStage.setMaximized(true);
         primaryStage.setTitle("Concentration");
         primaryStage.show();
         gameViewController.start();
         gameViewController.setStage(primaryStage);


      } catch (Exception e) {
         e.printStackTrace();
      }


   }
}
