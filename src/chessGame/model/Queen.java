package chessGame.model;

import javafx.geometry.Point2D;

public class Queen extends ChessPieces {
   public Queen(Point2D position){
      super(ChessPiecesType.QUEEN, position);
   }
   @Override
   public boolean canMove(Point2D nextPosition) {
      return true;
   }

   @Override
   public void capture() {

   }
}
