package chessGame.model;

import javafx.geometry.Point2D;

public class Bishop extends ChessPieces {

   public Bishop(Point2D position){
      super(ChessPiecesType.BISHOP,position);
   }

   @Override
   public boolean canMove(Point2D nextLocation) {
      return true;
   }

   @Override
   public void capture() {

   }
}
