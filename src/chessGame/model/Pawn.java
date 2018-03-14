package chessGame.model;

import chessGame.model.ChessPieceType;
import chessGame.model.GenericChessPiece;
import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends GenericChessPiece {

   public Pawn() {
      super(ChessPieceType.PAWN, 0, 0, 0);
   }

   public Pawn(int x, int y, int owner) {
      super(ChessPieceType.PAWN, x, y, owner);
   }

   @Override
   public List<Point2D> availableMove(int size) {

      ArrayList<Point2D> list = new ArrayList<>();
      if (getOwner() == 0 && getCurrentPosition().getY() < size - 2) {
         if (!getManager().isThereAPieceAt((int) getCurrentPosition().getX(), (int) getCurrentPosition().getY() + 1)) {
            list.add(new Point2D(getCurrentPosition().getX(), getCurrentPosition().getY() + 1));
         }

      }
      if (getOwner() == 1 && getCurrentPosition().getY() > 0) {
         if (!getManager().isThereAPieceAt((int) getCurrentPosition().getX(), (int) getCurrentPosition().getY() - 1)) {
            list.add(new Point2D(getCurrentPosition().getX(), getCurrentPosition().getY() - 1));
         }
      }
      return list;
   }

   @Override
   public List<Point2D> availableCapture(int size) {
      ArrayList<Point2D> list = new ArrayList<>();
      if (getOwner() == 0 && getCurrentPosition().getY() < size - 2) {
         if (getCurrentPosition().getX() > 0) {
            if (getManager().isThereAPieceAt((int) getCurrentPosition().getX() - 1, (int) getCurrentPosition().getY() + 1) &&
                    getManager().getPieceAt((int) getCurrentPosition().getX() - 1, (int) getCurrentPosition().getY() + 1).getOwner() != getOwner()) {
               list.add(new Point2D(getCurrentPosition().getX() - 1, getCurrentPosition().getY() + 1));
            }

         }
         if (getCurrentPosition().getX() < size - 1) {
            if (getManager().isThereAPieceAt((int) getCurrentPosition().getX() + 1, (int) getCurrentPosition().getY() + 1) &&
                    getManager().getPieceAt((int) getCurrentPosition().getX() + 1, (int) getCurrentPosition().getY() + 1).getOwner() != getOwner()) {
               list.add(new Point2D(getCurrentPosition().getX() + 1, getCurrentPosition().getY() + 1));
            }

         }

      }
      if (getOwner() == 1 && getCurrentPosition().getY() > 0) {
         if (getCurrentPosition().getX() > 0) {
            if (getManager().isThereAPieceAt((int) getCurrentPosition().getX() - 1, (int) getCurrentPosition().getY() - 1) &&
                    getManager().getPieceAt((int) getCurrentPosition().getX() - 1, (int) getCurrentPosition().getY() - 1).getOwner() != getOwner()) {
               list.add(new Point2D(getCurrentPosition().getX() - 1, getCurrentPosition().getY() - 1));
            }

         }
         if (getCurrentPosition().getX() < size - 1) {
            if (getManager().isThereAPieceAt((int) getCurrentPosition().getX() + 1, (int) getCurrentPosition().getY() - 1) &&
                    getManager().getPieceAt((int) getCurrentPosition().getX() + 1, (int) getCurrentPosition().getY() - 1).getOwner() != getOwner()) {
               list.add(new Point2D(getCurrentPosition().getX() + 1, getCurrentPosition().getY() - 1));
            }

         }
      }

      return list;
   }

   @Override
   public void capture() {

   }

   @Override
   public void captured() {

   }
}
