package FullChessGame.model;

import javafx.geometry.Point2D;

import java.util.List;

public class Queen extends GenericChessPiece {
   public Queen() {
      super(ChessPieceType.QUEEN, 0, 0, 0);
   }

   public Queen(int x, int y, int owner) {
      super(ChessPieceType.QUEEN, x, y, owner);
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
