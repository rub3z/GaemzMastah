package chessGame.model;

import chessGame.model.ChessManager;
import chessGame.model.ChessPieceType;
import javafx.geometry.Point2D;

import java.util.List;

public abstract class GenericChessPiece {
   private ChessPieceType type;
   private Point2D currentPosition;
   private int owner;
   private ChessManager manager;

   public GenericChessPiece() {
      type = ChessPieceType.PAWN;
      currentPosition = new Point2D(0, 0);
      owner = 0;
   }

   public GenericChessPiece(ChessPieceType type, int x, int y, int owner) {
      this.type = type;
      currentPosition = new Point2D(x, y);
      this.owner = owner;
   }


   public boolean move(Point2D nextPosition) {
      setCurrentPosition(nextPosition);
      return true;
   }

   public abstract void capture();

   public abstract void captured();

   public abstract List<Point2D> availableMove(int size);

   public abstract List<Point2D> availableCapture(int size);

   public Point2D getCurrentPosition() {
      return currentPosition;
   }

   public void setCurrentPosition(Point2D currentPosition) {
      this.currentPosition = currentPosition;
   }

   public int getOwner() {
      return owner;
   }

   public ChessManager getManager() {
      return manager;
   }

   public void setManager(ChessManager manager) {
      this.manager = manager;
   }

   public ChessPieceType getType() {
      return type;
   }
}
