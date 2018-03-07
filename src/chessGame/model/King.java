package chessGame.model;

import javafx.geometry.Point2D;

public class King extends ChessPieces{
   public King(Point2D position){
      super(ChessPiecesType.KING, position);
   }

   @Override
   public boolean canMove(Point2D nextPosition) {
      return true;
   }

   @Override
   public void capture() {

   }
}
