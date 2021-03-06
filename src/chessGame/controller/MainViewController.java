package chessGame.controller;

import chessGame.model.ChessManager;
import chessGame.model.ChessPieceType;
import chessGame.model.GenericChessPiece;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
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
         checkForPromotion(x, y);
         chessManager.switchTurn();
      }
      if (result == 2) {
         gameViewController.capture((int) selected.getX(), (int) selected.getY(), x, y);
         updateCapture();
         checkForPromotion(x, y);
         chessManager.switchTurn();
      }
      int win = chessManager.checkWin();

      if (win != -1) {
         displayVictoryScreen(win);
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
      ObservableList<ChessPieceType> player0CapturedList = FXCollections.observableArrayList(chessManager.getPlayer(0));
      p0Captured.setItems(player0CapturedList);
      ObservableList<ChessPieceType> player1CapturedList = FXCollections.observableArrayList(chessManager.getPlayer(1));
      p1Captured.setItems(player1CapturedList);
   }

   public void displayPromotion(int x, int y, int owner) {
      try {
         Stage stage = new Stage();
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/chessGame/view/Promotion.fxml"));
         Parent parent = fxmlLoader.load();
         PromotionController promotionController = fxmlLoader.getController();
         promotionController.setMainViewController(this);
         promotionController.setStyle(owner);
         promotionController.setTarget(x, y);
         Scene scene = new Scene(parent);
         stage.setScene(scene);
         stage.setTitle("Promotion");
         stage.setMaximized(false);
         stage.initOwner(gameViewController.getNodeByRowColumnIndex(0, 0).getScene().getWindow());
         stage.initModality(Modality.APPLICATION_MODAL);
         stage.show();

      } catch (Exception e) {
         e.printStackTrace();
      }

   }

   public void checkForPromotion(int x, int y) {
      GenericChessPiece genericChessPiece = chessManager.getPieceAt(x, y);
      //Black
      if (genericChessPiece.getType() == ChessPieceType.PAWN && genericChessPiece.getOwner() == 0
              && genericChessPiece.getCurrentPosition().getY() == chessManager.getSize() - 1) {
         displayPromotion(x, y, genericChessPiece.getOwner());
      }
      //White
      if (genericChessPiece.getType() == ChessPieceType.PAWN && genericChessPiece.getOwner() == 1
              && genericChessPiece.getCurrentPosition().getY() == 0) {
         displayPromotion(x, y, genericChessPiece.getOwner());
      }
   }

   public void promotion(ChessPieceType type, int x, int y) {
      chessManager.promotion(type, x, y);
      gameViewController.createNewPiece(type, x, y, chessManager.getPieceAt(x, y).getOwner());
   }

   public String getTurn() {
      int turn = chessManager.getTurn();
      if (turn == 0) {
         return "Piece0";
      } else {
         return "Piece1";
      }
   }

   public void displayVictoryScreen(int winner) {
      try {
         Stage stage = new Stage();
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/chessGame/view/EndgameScreen.fxml"));
         Parent parent = fxmlLoader.load();
         EndgameScreenController endgameScreenController = fxmlLoader.getController();
         endgameScreenController.setMainViewController(this);
         endgameScreenController.updateData(chessManager.getRemainingPieces(0), chessManager.getRemainingPieces(1), chessManager.getCapturedPieces(0), chessManager.getCapturedPieces(1));
         endgameScreenController.updateWinner(winner);
         Scene scene = new Scene(parent);
         stage.setScene(scene);
         stage.setTitle("Victory");
         stage.setMaximized(false);
         stage.initOwner(gameViewController.getNodeByRowColumnIndex(0, 0).getScene().getWindow());
         stage.initModality(Modality.APPLICATION_MODAL);
         stage.show();

      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public void restart() {
      chessManager = new ChessManager();
      gameViewController.start();
   }

   public void close() {
      Stage stage = (Stage) p0.getScene().getWindow();
      stage.close();
   }
}
