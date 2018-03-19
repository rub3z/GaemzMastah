package gaemzmastah;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class GaemzMastah extends Application {

   private Circle circle;
   private Pane content;
   private ScrollPane scrollPane;

   public static void main(String[] args) {
      launch(args);
   }

   // update circle position to be centered in the viewport
   private void update() {
      Bounds viewportBounds = scrollPane.getViewportBounds();
      Bounds contentBounds = content.getBoundsInLocal();

      double hRel = scrollPane.getHvalue() / scrollPane.getHmax();
      double vRel = scrollPane.getVvalue() / scrollPane.getVmax();

      double x = Math.max(0, (contentBounds.getWidth() - viewportBounds.getWidth()) * hRel) + viewportBounds.getWidth() / 2;
      double y = Math.max(0, (contentBounds.getHeight() - viewportBounds.getHeight()) * vRel) + viewportBounds.getHeight() / 2;

      Point2D localCoordinates = content.parentToLocal(x, y);
      circle.setCenterX(localCoordinates.getX());
      circle.setCenterY(localCoordinates.getY());
   }

   @Override
   public void start(Stage primaryStage) {
      // create ui
      circle = new Circle(10);
      content = new Pane(circle);
      content.setPrefSize(4000, 4000);
      scrollPane = new ScrollPane(content);
      Scene scene = new Scene(scrollPane, 400, 400);

      // add listener to properties that may change
      InvalidationListener l = o -> update();
      content.layoutBoundsProperty().addListener(l);
      scrollPane.viewportBoundsProperty().addListener(l);
      scrollPane.hvalueProperty().addListener(l);
      scrollPane.vvalueProperty().addListener(l);
      scrollPane.hmaxProperty().addListener(l);
      scrollPane.vmaxProperty().addListener(l);
      scrollPane.hminProperty().addListener(l);
      scrollPane.vminProperty().addListener(l);

      primaryStage.setScene(scene);
      primaryStage.show();
   }

}