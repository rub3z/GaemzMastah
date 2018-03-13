package FullChessGame.controller;

import FullChessGame.model.ChessManager;
import FullChessGame.model.ChessPieceType;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {
   @FXML
   private GameViewController gameViewController;
   @FXML
   private Label p0, p1;
   @FXML
   private ListView p0Captured, p1Captured;
   private ChessManager chessManager;
   private Point2D selected;

   public MainViewController() {
      chessManager = new ChessManager();
      selected = null;
   }

   @Override
   public void initialize(URL location, ResourceBundle resources) {
      gameViewController.setMainViewController(this);
      p0.setText("Black");
      p1.setText("White");
   }

   public void start() {
      gameViewController.start();
   }

   public void rePositionAllPieces(Stage stage) {
      PauseTransition pause = new PauseTransition(Duration.seconds(0.01));
      stage.xProperty().addListener((obs, oldVal, newVal) -> {
         pause.setOnFinished(event -> gameViewController.rePositionAllPieces());
         pause.playFromStart();
      });
      stage.yProperty().addListener((obs, oldVal, newVal) -> {
         pause.setOnFinished(event -> gameViewController.rePositionAllPieces());
         pause.playFromStart();
      });

   }

   public void play(int x, int y) {

      int result = chessManager.move((int) selected.getX(), (int) selected.getY(), x, y);
      if (result == 1) {
         gameViewController.move((int) selected.getX(), (int) selected.getY(), x, y);
      }
      if (result == 2) {
         gameViewController.capture((int) selected.getX(), (int) selected.getY(), x, y);
         updateCapture();
      }
      selected = null;


   }

   public void displayMove(int x, int y) {
      if (chessManager.getAvailableMove(x, y).size() > 0) {
         gameViewController.displayAvailableMove(chessManager.getAvailableMove(x, y));
      }
      if (chessManager.getAvailableCapture(x, y).size() > 0) {
         gameViewController.displayAvailableCapture(chessManager.getAvailableCapture(x, y));

      }
   }

   public Point2D getSelected() {
      return selected;
   }

   public void setSelected(Point2D point2D) {
      this.selected = point2D;
   }

   public void updateCapture() {
      System.out.println(chessManager.getPlayer(0).size());
      System.out.println(chessManager.getPlayer(1).size());
      ObservableList<ChessPieceType> player0CapturedList = FXCollections.observableArrayList(chessManager.getPlayer(0));
      p0Captured.setItems(player0CapturedList);
      ObservableList<ChessPieceType> player1CapturedList = FXCollections.observableArrayList(chessManager.getPlayer(1));
      p1Captured.setItems(player1CapturedList);
   }
}
