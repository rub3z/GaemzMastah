package chessGame.model;


import javafx.geometry.Point2D;

public abstract class ChessPieces {
   private ChessPiecesType type;
   private Point2D currentPosition;

   public ChessPieces(ChessPiecesType type, Point2D currentPosition){
      this.type=type;
      this.currentPosition=currentPosition;
   }
   public ChessPieces(){
      this.type=ChessPiecesType.PAWN;
      this.currentPosition=new Point2D(0,0);
   }

   public void move(Point2D nextPosition){
      boolean canMove=canMove(nextPosition);
      if (canMove){
         currentPosition=nextPosition;
      }
   }

   public void setCurrentPositiont(Point2D position){
      currentPosition=position;
   }
   public abstract boolean canMove(Point2D nextPosition);
   public abstract void capture();
}
