package chessGame.model;

import javafx.geometry.Point2D;

public class Rock extends ChessPieces{
   public Rock(Point2D position){
      super(ChessPiecesType.ROCK,position);
   }
   @Override
   public boolean canMove(Point2D nextPosition) {
      return true;
   }

   @Override
   public void capture() {

   }
}
