package mazeGame.controller;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import mazeGame.model.Cell;
import mazeGame.model.Direction;

import java.util.ArrayList;


public class GameViewController {
   private MainViewController mainViewController;
   @FXML
   private Canvas mazeDrawable, fogDrawable;
   @FXML
   private ScrollPane scrollPanel;
   private GraphicsContext gcMazeDrawable, gcFogDrawable;
   private Circle player;
   private boolean isAnimation = false;
   private ArrayList<TranslateTransition> translateTransitionsList;

   private double scale;

   public GameViewController() {
      scale = 50;
      player = new Circle();
      player.setRadius(10);
      player.setFill(Color.web("#66fcf1"));
      translateTransitionsList = new ArrayList<TranslateTransition>();
   }

   @FXML
   public void initialize() {
      gcMazeDrawable = mazeDrawable.getGraphicsContext2D();
      gcFogDrawable = fogDrawable.getGraphicsContext2D();
      gcMazeDrawable.setStroke(Color.web("#45a29e"));
      gcMazeDrawable.setFill(Color.web("#45a29e"));
      gcMazeDrawable.setLineWidth(5);
      gcFogDrawable.setFill(Color.web("#0b0c10"));
      gcFogDrawable.fillRect(0, 0, fogDrawable.getWidth(), fogDrawable.getHeight());
      AnchorPane anchorPane = (AnchorPane) mazeDrawable.getParent();
      anchorPane.getChildren().add(player);

   }

   public void setMainViewController(MainViewController mainViewController) {
      this.mainViewController = mainViewController;
   }

   public void drawPlayer(Point2D point2D) {
      TranslateTransition translateTransition = new TranslateTransition();
      translateTransition.setDuration(Duration.seconds(0.001));
      translateTransition.setNode(player);
      translateTransition.setToX((point2D.getX() + 0.7) * scale);
      translateTransition.setToY((point2D.getY() + 0.7) * scale);
      translateTransitionsList.add(translateTransition);
      translateTransition.setOnFinished(e -> {
         if (translateTransitionsList.size() > 0) {

            translateTransitionsList.remove(0).play();

         } else {
            isAnimation = false;

         }

      });
      if (isAnimation == false && translateTransitionsList.size() > 0) {
         isAnimation = true;
         translateTransitionsList.remove(0).play();
      }


      //Add fog of war
      adjustViewBox(point2D);
      gcFogDrawable.clearRect((point2D.getX()) * scale, (point2D.getY()) * scale, 2 * scale, 1.5 * scale);

   }

   public void drawMap(Cell[][] mazeMap, Point2D start, Point2D end) {
      gcFogDrawable.setFill(Color.web("#0b0c10"));
      gcFogDrawable.fillRect(0, 0, fogDrawable.getWidth(), fogDrawable.getHeight());
      gcMazeDrawable.clearRect(0, 0, mazeDrawable.getWidth(), mazeDrawable.getHeight());
      for (int i = 0; i < mazeMap.length; i++) {
         for (int j = 0; j < mazeMap[i].length; j++) {
            // East
            if (mazeMap[i][j].getSide(Direction.East))
               gcMazeDrawable.strokeLine((mazeMap[i][j].getX() + 1) * scale, mazeMap[i][j].getY() * scale,
                       (mazeMap[i][j].getX() + 1) * scale, (mazeMap[i][j].getY() + 1) * scale);
            // West
            if (mazeMap[i][j].getSide(Direction.West))
               gcMazeDrawable.strokeLine(mazeMap[i][j].getX() * scale, mazeMap[i][j].getY() * scale,
                       mazeMap[i][j].getX() * scale, (mazeMap[i][j].getY() + 1) * scale);
            // North
            if (mazeMap[i][j].getSide(Direction.North))
               gcMazeDrawable.strokeLine(mazeMap[i][j].getX() * scale, mazeMap[i][j].getY() * scale,
                       (mazeMap[i][j].getX() + 1) * scale, mazeMap[i][j].getY() * scale);
            // South
            if (mazeMap[i][j].getSide(Direction.South))
               gcMazeDrawable.strokeLine(mazeMap[i][j].getX() * scale, (mazeMap[i][j].getY() + 1) * scale,
                       (mazeMap[i][j].getX() + 1) * scale, (mazeMap[i][j].getY() + 1) * scale);

         }
      }
      gcMazeDrawable.fillText("S", (start.getX() + 0.4) * scale, (start.getY() + 0.65) * scale);
      gcMazeDrawable.fillText("E", (end.getX() + 0.4) * scale, (end.getY() + 0.65) * scale);
   }

   public ScrollPane getScrollPanel() {
      return scrollPanel;
   }

   public void adjustViewBox(Point2D point2D) {
      double h = scrollPanel.getContent().getBoundsInLocal().getHeight();
      double y = ((point2D.getY() + 1) * scale +
              point2D.getY() * scale) / 2.0;
      double v = scrollPanel.getViewportBounds().getHeight();
      scrollPanel.setVvalue(scrollPanel.getVmax() * ((y - 0.5 * v) / (h - v)));
      double a = scrollPanel.getContent().getBoundsInLocal().getWidth();
      double b = ((point2D.getX() + 1) * scale +
              point2D.getX() * scale) / 2.0;
      double c = scrollPanel.getViewportBounds().getWidth();
      scrollPanel.setHvalue(scrollPanel.getHmax() * ((b - 0.5 * c) / (a - c)));
   }

   public void clearCanvas() {
      gcMazeDrawable.clearRect(0, 0, mazeDrawable.getWidth(), mazeDrawable.getHeight());
      gcFogDrawable.clearRect(0, 0, fogDrawable.getWidth(), fogDrawable.getHeight());
   }

}
