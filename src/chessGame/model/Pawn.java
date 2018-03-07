package chessGame.model;

import javafx.geometry.Point2D;

public class Pawn extends ChessPieces {
   public Pawn(Point2D position){
      super(ChessPiecesType.PAWN,position);
   }
   @Override
   public boolean canMove(Point2D nextPosition) {
      return true;
   }

   @Override
   public void capture() {

   }
}
