package chessGame.model;

import javafx.geometry.Point2D;

public class Knight extends ChessPieces {
   public Knight(Point2D position){
      super(ChessPiecesType.KNIGHT,position);
   }
   @Override
   public boolean canMove(Point2D nextPosition) {
      return true;
   }

   @Override
   public void capture() {

   }
}
