package chessGame.controller;

import chessGame.controller.MainViewController;
import chessGame.model.ChessPieceType;
import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class GameViewController implements Initializable {
   final int size = 6;
   private ImageView[][] pieces = new ImageView[size][size];
   private Rectangle[][] board = new Rectangle[size][size];
   @FXML
   private GridPane gridPane;
   private MainViewController mainViewController;

   public void createBoard() {
      for (int i = 0; i < size; i++) {
         for (int j = 0; j < size; j++) {
            Rectangle rectangle = new Rectangle();
            if ((i + j) % 2 == 0) {
               rectangle.setFill(Color.web("#f1f1f2"));
            } else {
               rectangle.setFill(Color.web("#1995ad"));
            }
            rectangle.heightProperty().bind(((StackPane) gridPane.getParent()).heightProperty().divide(size));
            rectangle.widthProperty().bind(((StackPane) gridPane.getParent()).heightProperty().divide(size));
            board[j][i] = rectangle;
            gridPane.add(rectangle, i, j);

            rectangle.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
               clicked(event);
            });
         }
      }
   }

   public void start() {
      while (gridPane.getChildren().remove(gridPane.lookup("#Piece0"))) {

      }
      while (gridPane.getChildren().remove(gridPane.lookup("#Piece1"))) {

      }
      for (int i = 0; i < pieces.length; i++)
         Arrays.fill(pieces[i], null);
      createPiece();
   }

   public void createPiece() {
      Rectangle a = board[0][0];
      //Black piece
      //Pawn
      ImageView imageView;
      for (int i = 0; i < board[0].length; i++) {
         imageView = new ImageView(new Image("chessGame/resources/chessPieces/B_Pawn.png"));
         imageView.fitHeightProperty().bind(a.heightProperty());
         imageView.fitWidthProperty().bind(a.widthProperty());
         imageView.setId("Piece0");
         gridPane.getChildren().add(imageView);
         imageView.setMouseTransparent(true);
         pieces[size / 2][size / 2] = imageView;
         move(size / 2, size / 2, i, 1);
      }

      //Rook

      imageView = new ImageView(new Image("chessGame/resources/chessPieces/B_Rook.png"));
      imageView.fitHeightProperty().bind(a.heightProperty());
      imageView.fitWidthProperty().bind(a.widthProperty());
      imageView.setId("Piece0");
      gridPane.getChildren().add(imageView);
      imageView.setMouseTransparent(true);
      pieces[size / 2][size / 2] = imageView;
      move(size / 2, size / 2, 0, 0);

      imageView = new ImageView(new Image("chessGame/resources/chessPieces/B_Rook.png"));
      imageView.fitHeightProperty().bind(a.heightProperty());
      imageView.fitWidthProperty().bind(a.widthProperty());
      imageView.setId("Piece0");
      gridPane.getChildren().add(imageView);
      imageView.setMouseTransparent(true);
      pieces[size / 2][size / 2] = imageView;
      move(size / 2, size / 2, size - 1, 0);

      //Knight
      imageView = new ImageView(new Image("chessGame/resources/chessPieces/B_Knight.png"));
      imageView.fitHeightProperty().bind(a.heightProperty());
      imageView.fitWidthProperty().bind(a.widthProperty());
      imageView.setId("Piece0");
      gridPane.getChildren().add(imageView);
      imageView.setMouseTransparent(true);
      pieces[size / 2][size / 2] = imageView;
      move(size / 2, size / 2, 1, 0);

      imageView = new ImageView(new Image("chessGame/resources/chessPieces/B_Knight.png"));
      imageView.fitHeightProperty().bind(a.heightProperty());
      imageView.fitWidthProperty().bind(a.widthProperty());
      imageView.setId("Piece0");
      gridPane.getChildren().add(imageView);
      imageView.setMouseTransparent(true);
      pieces[size / 2][size / 2] = imageView;
      move(size / 2, size / 2, size - 2, 0);

      //Bishop
      imageView = new ImageView(new Image("chessGame/resources/chessPieces/B_Bishop.png"));
      imageView.fitHeightProperty().bind(a.heightProperty());
      imageView.fitWidthProperty().bind(a.widthProperty());
      imageView.setId("Piece0");
      gridPane.getChildren().add(imageView);
      imageView.setMouseTransparent(true);
      pieces[size / 2][size / 2] = imageView;
      move(size / 2, size / 2, 2, 0);

      imageView = new ImageView(new Image("chessGame/resources/chessPieces/B_Bishop.png"));
      imageView.fitHeightProperty().bind(a.heightProperty());
      imageView.fitWidthProperty().bind(a.widthProperty());
      imageView.setId("Piece0");
      gridPane.getChildren().add(imageView);
      imageView.setMouseTransparent(true);
      pieces[size / 2][size / 2] = imageView;
      move(size / 2, size / 2, size - 3, 0);


      //White Piece
      //Pawn
      for (int i = 0; i < board[0].length; i++) {
         imageView = new ImageView(new Image("chessGame/resources/chessPieces/W_Pawn.png"));
         imageView.fitHeightProperty().bind(a.heightProperty());
         imageView.fitWidthProperty().bind(a.widthProperty());
         imageView.setId("Piece1");
         gridPane.getChildren().add(imageView);
         imageView.setMouseTransparent(true);
         pieces[size / 2][size / 2] = imageView;
         move(size / 2, size / 2, i, size - 2);
      }

      //Rook

      imageView = new ImageView(new Image("chessGame/resources/chessPieces/W_Rook.png"));
      imageView.fitHeightProperty().bind(a.heightProperty());
      imageView.fitWidthProperty().bind(a.widthProperty());
      imageView.setId("Piece1");
      gridPane.getChildren().add(imageView);
      imageView.setMouseTransparent(true);
      pieces[size / 2][size / 2] = imageView;
      move(size / 2, size / 2, 0, size - 1);

      imageView = new ImageView(new Image("chessGame/resources/chessPieces/W_Rook.png"));
      imageView.fitHeightProperty().bind(a.heightProperty());
      imageView.fitWidthProperty().bind(a.widthProperty());
      imageView.setId("Piece1");
      gridPane.getChildren().add(imageView);
      imageView.setMouseTransparent(true);
      pieces[size / 2][size / 2] = imageView;
      move(size / 2, size / 2, size - 1, size - 1);

      //Knight
      imageView = new ImageView(new Image("chessGame/resources/chessPieces/W_Knight.png"));
      imageView.fitHeightProperty().bind(a.heightProperty());
      imageView.fitWidthProperty().bind(a.widthProperty());
      imageView.setId("Piece1");
      gridPane.getChildren().add(imageView);
      imageView.setMouseTransparent(true);
      pieces[size / 2][size / 2] = imageView;
      move(size / 2, size / 2, 1, size - 1);

      imageView = new ImageView(new Image("chessGame/resources/chessPieces/W_Knight.png"));
      imageView.fitHeightProperty().bind(a.heightProperty());
      imageView.fitWidthProperty().bind(a.widthProperty());
      imageView.setId("Piece1");
      gridPane.getChildren().add(imageView);
      imageView.setMouseTransparent(true);
      pieces[size / 2][size / 2] = imageView;
      move(size / 2, size / 2, size - 2, size - 1);

      //Bishop
      imageView = new ImageView(new Image("chessGame/resources/chessPieces/W_Bishop.png"));
      imageView.fitHeightProperty().bind(a.heightProperty());
      imageView.fitWidthProperty().bind(a.widthProperty());
      imageView.setId("Piece1");
      gridPane.getChildren().add(imageView);
      imageView.setMouseTransparent(true);
      pieces[size / 2][size / 2] = imageView;
      move(size / 2, size / 2, 2, size - 1);

      imageView = new ImageView(new Image("chessGame/resources/chessPieces/W_Bishop.png"));
      imageView.fitHeightProperty().bind(a.heightProperty());
      imageView.fitWidthProperty().bind(a.widthProperty());
      imageView.setId("Piece1");
      gridPane.getChildren().add(imageView);
      imageView.setMouseTransparent(true);
      pieces[size / 2][size / 2] = imageView;
      move(size / 2, size / 2, size - 3, size - 1);


   }

   public Node getNodeByRowColumnIndex(final int column, final int row) {
      Node result = null;
      ObservableList<Node> childrens = gridPane.getChildren();

      for (Node node : childrens) {
         if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
            result = node;
            break;
         }
      }

      return result;
   }

   public void move(int x1, int y1, int x2, int y2) {
      TranslateTransition translateTransition = new TranslateTransition();
      translateTransition.setDuration(Duration.seconds(0.1));
      translateTransition.setNode(pieces[y1][x1]);
      Bounds bounds = board[y2][x2].getBoundsInParent();
      translateTransition.setToX(bounds.getMinX() - board[0][0].getBoundsInParent().getMinX());
      translateTransition.setToY(bounds.getMinY() - board[0][0].getBoundsInParent().getMinY());
      translateTransition.play();
      if (x1 != x2 || y1 != y2) {
         pieces[y2][x2] = pieces[y1][x1];
         pieces[y1][x1] = null;
      }


   }

   public void displayAvailableMove(List<Point2D> list) {
      for (Point2D point2D : list) {
         board[(int) point2D.getY()][(int) point2D.getX()].getStyleClass().add("blueFate");
      }
   }

   public void displayAvailableCapture(List<Point2D> list) {
      for (Point2D point2D : list) {
         board[(int) point2D.getY()][(int) point2D.getX()].getStyleClass().add("redFate");
      }
   }

   public void displaySelectedPiece(Point2D point2D) {
      board[(int) point2D.getY()][(int) point2D.getX()].getStyleClass().add("yellowFate");
   }

   public void clearEffect() {
      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[0].length; j++) {
            board[i][j].getStyleClass().clear();
         }
      }
   }

   public void setMainViewController(MainViewController mainViewController) {
      this.mainViewController = mainViewController;
   }

   @Override
   public void initialize(URL location, ResourceBundle resources) {
      createBoard();
   }

   public void rePositionAllPieces() {
      for (int i = 0; i < pieces.length; i++) {
         for (int j = 0; j < pieces[0].length; j++) {
            move(j, i, j, i);
         }
      }
   }

   public void clicked(MouseEvent mouseEvent) {
      //Clear all style
      clearEffect();
      //Highlight selected piece
      Rectangle rectangle = (Rectangle) mouseEvent.getSource();


      //Update Selector
      if (pieces[GridPane.getRowIndex(rectangle)][GridPane.getColumnIndex(rectangle)] != null) {
         if (mainViewController.getSelected() == null) {
            mainViewController.setSelected(new Point2D(GridPane.getColumnIndex(rectangle), GridPane.getRowIndex(rectangle)));
            displaySelectedPiece(new Point2D(GridPane.getColumnIndex(rectangle), GridPane.getRowIndex(rectangle)));
            mainViewController.displayMove(GridPane.getColumnIndex(rectangle), GridPane.getRowIndex(rectangle));
         } else if (pieces[(int) mainViewController.getSelected().getY()][(int) mainViewController.getSelected().getX()].getId().compareTo
                 (pieces[GridPane.getRowIndex(rectangle)][GridPane.getColumnIndex(rectangle)].getId()) == 0) {
            mainViewController.setSelected(new Point2D(GridPane.getColumnIndex(rectangle), GridPane.getRowIndex(rectangle)));
            displaySelectedPiece(new Point2D(GridPane.getColumnIndex(rectangle), GridPane.getRowIndex(rectangle)));
            mainViewController.displayMove(GridPane.getColumnIndex(rectangle), GridPane.getRowIndex(rectangle));
         }
      }
      //Play
      if (mainViewController.getSelected() != null) {
         if (mainViewController.getSelected().getX() != GridPane.getColumnIndex(rectangle) || mainViewController.getSelected().getY() != GridPane.getRowIndex(rectangle)) {
            mainViewController.play(GridPane.getColumnIndex(rectangle), GridPane.getRowIndex(rectangle));
         }
      }


   }

   public void capture(int x1, int y1, int x2, int y2) {
      ImageView capturedPiece = pieces[y2][x2];
      TranslateTransition translateTransition = new TranslateTransition();
      translateTransition.setDuration(Duration.seconds(0.1));
      translateTransition.setNode(pieces[y1][x1]);
      Bounds bounds = board[y2][x2].getBoundsInParent();
      translateTransition.setToX(bounds.getMinX() - board[0][0].getBoundsInParent().getMinX());
      translateTransition.setToY(bounds.getMinY() - board[0][0].getBoundsInParent().getMinY());
      translateTransition.play();
      translateTransition.setOnFinished(e -> {
         gridPane.getChildren().remove(capturedPiece);
      });
      if (x1 != x2 || y1 != y2) {
         pieces[y2][x2] = pieces[y1][x1];
         pieces[y1][x1] = null;
      }
   }

   public void createNewPiece(ChessPieceType type, int x, int y, int owner) {
      switch (type) {
         case QUEEN:
            break;
         case ROOK:
            break;
         case BISHOP:
            break;
         case KNIGHT:

            break;
         default:

            break;
      }
   }

}

