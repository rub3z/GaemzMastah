package concentrationGame.controller;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GameViewController implements Initializable {
   /**
    * This is the container contains all cell.
    */
   @FXML
   private FlowPane pane;

   /**
    * The main controller.
    */
   private MainViewController mainViewController;


   /**
    * List of all cell. Must be in the same order as model.
    */
   private ArrayList<StackPane> list;

   /**
    * Called to initialize a controller after its root element has been
    * completely processed.
    *
    * @param location  The location used to resolve relative paths for the root object, or
    *                  <tt>null</tt> if the location is not known.
    * @param resources The resources used to localize the root object, or <tt>null</tt> if
    */
   @Override
   public void initialize(URL location, ResourceBundle resources) {
      list=new ArrayList<>();
   }


   /**
    *
    * This method is used to create cell object by passing in the path of the image and add listener to those objects so that when it is clicked, it will flip.
    * @param path The relative path to the image.
    */
   public void createCells(String path) {
      StackPane panel = new StackPane();
      Image image0 = new Image(path, 800, 600, false, false);
      ImageView foreground = new ImageView();
      foreground.setImage(image0);
      foreground.setFitHeight(200);
      foreground.setFitWidth(200);
      foreground.setSmooth(true);
      foreground.setCache(true);

      Image image1 = new Image("concentrationGame/resources/background.png", 800, 600, false, false);
      ImageView background = new ImageView();
      background.setImage(image1);
      background.setFitHeight(200);
      background.setFitWidth(200);
      background.setSmooth(true);
      background.setCache(true);


      panel.getChildren().addAll(foreground, background);
      //Add to list
      list.add(panel);
      pane.getChildren().add(panel);
      panel.rotateProperty().addListener((observable, oldValue, newValue) -> {

         if (newValue.intValue() < 90) {
            background.toFront();
         } else {
            foreground.toFront();
         }

      });
      panel.setOnMouseClicked(event -> {
         flipImage((Node) event.getSource()).play();
      });


   }


   /**
    * This method is used to create rotation transition a.k.a rotating animation.
    * @param cell is the node that need to be rotated
    * @return Animation of the rotation.
    */
   private RotateTransition flipImage(Node cell) {
      cell.setDisable(true);
      RotateTransition rotator = new RotateTransition(Duration.millis(1000), cell);
      rotator.setAxis(Rotate.Y_AXIS);
      StackPane stackPane = (StackPane) cell;
      if (stackPane.getRotate() == 180) {
         rotator.setFromAngle(180);
         rotator.setToAngle(0);
      } else {
         rotator.setFromAngle(0);
         rotator.setToAngle(180);
      }

      rotator.setOnFinished(event -> {
         cell.setDisable(false);
      });

      return rotator;
   }

   /**
    * Set the main controller
    * @param mainViewController Main Controller.
    */
   public void setMainViewController(MainViewController mainViewController){
      this.mainViewController=mainViewController;
   }
}
