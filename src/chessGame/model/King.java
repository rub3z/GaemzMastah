package chessGame.model;

import chessGame.model.ChessPieceType;
import chessGame.model.GenericChessPiece;
import javafx.geometry.Point2D;

import java.util.List;

public class King extends GenericChessPiece {
   public King() {
      super(ChessPieceType.KING, 0, 0, 0);
   }

   public King(int x, int y, int owner) {
      super(ChessPieceType.KING, x, y, owner);
   }


   @Override
   public void capture() {

   }

   @Override
   public void captured() {

   }

   @Override
   public List<Point2D> availableMove(int size) {
      return null;
   }

   @Override
   public List<Point2D> availableCapture(int size) {
      return null;
   }
}
