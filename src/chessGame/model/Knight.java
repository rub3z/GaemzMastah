package FullChessGame.model;

import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.List;

public class Knight extends GenericChessPiece {

   public Knight() {
      super(ChessPieceType.KNIGHT, 0, 0, 0);
   }

   public Knight(int x, int y, int owner) {
      super(ChessPieceType.KNIGHT, x, y, owner);
   }


   @Override
   public void capture() {

   }

   @Override
   public void captured() {

   }

   @Override
   public List<Point2D> availableMove(int size) {
      ArrayList<Point2D> list = new ArrayList<>();
      if (getCurrentPosition().getX() - 2 >= 0 &&
              getCurrentPosition().getY() - 1 >= 0 && !getManager().isThereAPieceAt((int) getCurrentPosition().getX() - 2, (int) getCurrentPosition().getY() - 1)) {
         list.add(new Point2D(getCurrentPosition().getX() - 2, getCurrentPosition().getY() - 1));
      }
      if (getCurrentPosition().getX() - 1 >= 0 &&
              getCurrentPosition().getY() - 2 >= 0 && !getManager().isThereAPieceAt((int) getCurrentPosition().getX() - 1, (int) getCurrentPosition().getY() - 2)) {
         list.add(new Point2D(getCurrentPosition().getX() - 1, getCurrentPosition().getY() - 2));
      }

      if (getCurrentPosition().getX() + 1 < size &&
              getCurrentPosition().getY() - 2 >= 0 && !getManager().isThereAPieceAt((int) getCurrentPosition().getX() + 1, (int) getCurrentPosition().getY() - 2)) {
         list.add(new Point2D(getCurrentPosition().getX() + 1, getCurrentPosition().getY() - 2));
      }
      if (getCurrentPosition().getX() + 2 < size &&
              getCurrentPosition().getY() - 1 >= 0 && !getManager().isThereAPieceAt((int) getCurrentPosition().getX() + 2, (int) getCurrentPosition().getY() - 1)) {
         list.add(new Point2D(getCurrentPosition().getX() + 2, getCurrentPosition().getY() - 1));
      }
      if (getCurrentPosition().getX() - 2 >= 0 &&
              getCurrentPosition().getY() + 1 < size && !getManager().isThereAPieceAt((int) getCurrentPosition().getX() - 2, (int) getCurrentPosition().getY() + 1)) {
         list.add(new Point2D(getCurrentPosition().getX() - 2, getCurrentPosition().getY() + 1));
      }
      if (getCurrentPosition().getX() - 1 >= 0 &&
              getCurrentPosition().getY() + 2 < size && !getManager().isThereAPieceAt((int) getCurrentPosition().getX() - 1, (int) getCurrentPosition().getY() + 2)) {
         list.add(new Point2D(getCurrentPosition().getX() - 1, getCurrentPosition().getY() + 2));
      }

      if (getCurrentPosition().getX() + 1 < size &&
              getCurrentPosition().getY() + 2 < size && !getManager().isThereAPieceAt((int) getCurrentPosition().getX() + 1, (int) getCurrentPosition().getY() + 2)) {
         list.add(new Point2D(getCurrentPosition().getX() + 1, getCurrentPosition().getY() + 2));
      }
      if (getCurrentPosition().getX() + 2 < size &&
              getCurrentPosition().getY() + 1 < size && !getManager().isThereAPieceAt((int) getCurrentPosition().getX() + 2, (int) getCurrentPosition().getY() + 1)) {
         list.add(new Point2D(getCurrentPosition().getX() + 2, getCurrentPosition().getY() + 1));
      }
      return list;

   }

   @Override
   public List<Point2D> availableCapture(int size) {

      ArrayList<Point2D> list = new ArrayList<>();
      if (getCurrentPosition().getX() - 2 >= 0 &&
              getCurrentPosition().getY() - 1 >= 0 && getManager().isThereAPieceAt((int) getCurrentPosition().getX() - 2, (int) getCurrentPosition().getY() - 1)) {
         if (getManager().getPieceAt((int) getCurrentPosition().getX() - 2, (int) getCurrentPosition().getY() - 1).getOwner() != getOwner()) {
            list.add(new Point2D(getCurrentPosition().getX() - 2, getCurrentPosition().getY() - 1));
         }

      }
      if (getCurrentPosition().getX() - 1 >= 0 &&
              getCurrentPosition().getY() - 2 >= 0 && getManager().isThereAPieceAt((int) getCurrentPosition().getX() - 1, (int) getCurrentPosition().getY() - 2)) {
         if (getManager().getPieceAt((int) getCurrentPosition().getX() - 1, (int) getCurrentPosition().getY() - 2).getOwner() != getOwner()) {
            list.add(new Point2D(getCurrentPosition().getX() - 1, getCurrentPosition().getY() - 2));
         }

      }

      if (getCurrentPosition().getX() + 1 < size &&
              getCurrentPosition().getY() - 2 >= 0 && getManager().isThereAPieceAt((int) getCurrentPosition().getX() + 1, (int) getCurrentPosition().getY() - 2)) {
         if (getManager().getPieceAt((int) getCurrentPosition().getX() + 1, (int) getCurrentPosition().getY() - 2).getOwner() != getOwner()) {
            list.add(new Point2D(getCurrentPosition().getX() + 1, getCurrentPosition().getY() - 2));
         }

      }
      if (getCurrentPosition().getX() + 2 < size &&
              getCurrentPosition().getY() - 1 >= 0 && getManager().isThereAPieceAt((int) getCurrentPosition().getX() + 2, (int) getCurrentPosition().getY() - 1)) {
         if (getManager().getPieceAt((int) getCurrentPosition().getX() + 2, (int) getCurrentPosition().getY() - 1).getOwner() != getOwner()) {
            list.add(new Point2D(getCurrentPosition().getX() + 2, getCurrentPosition().getY() - 1));
         }

      }
      if (getCurrentPosition().getX() - 2 >= 0 &&
              getCurrentPosition().getY() + 1 < size && getManager().isThereAPieceAt((int) getCurrentPosition().getX() - 2, (int) getCurrentPosition().getY() + 1)) {
         if (getManager().getPieceAt((int) getCurrentPosition().getX() - 2, (int) getCurrentPosition().getY() + 1).getOwner() != getOwner()) {
            list.add(new Point2D(getCurrentPosition().getX() - 2, getCurrentPosition().getY() + 1));
         }

      }
      if (getCurrentPosition().getX() - 1 >= 0 &&
              getCurrentPosition().getY() + 2 < size && getManager().isThereAPieceAt((int) getCurrentPosition().getX() - 1, (int) getCurrentPosition().getY() + 2)) {
         if (getManager().getPieceAt((int) getCurrentPosition().getX() - 1, (int) getCurrentPosition().getY() + 2).getOwner() != getOwner()) {
            list.add(new Point2D(getCurrentPosition().getX() - 1, getCurrentPosition().getY() + 2));
         }

      }

      if (getCurrentPosition().getX() + 1 < size &&
              getCurrentPosition().getY() + 2 < size && getManager().isThereAPieceAt((int) getCurrentPosition().getX() + 1, (int) getCurrentPosition().getY() + 2)) {
         if (getManager().getPieceAt((int) getCurrentPosition().getX() + 1, (int) getCurrentPosition().getY() + 2).getOwner() != getOwner()) {
            list.add(new Point2D(getCurrentPosition().getX() + 1, getCurrentPosition().getY() + 2));
         }

      }
      if (getCurrentPosition().getX() + 2 < size &&
              getCurrentPosition().getY() + 1 < size && getManager().isThereAPieceAt((int) getCurrentPosition().getX() + 2, (int) getCurrentPosition().getY() + 1)) {
         if (getManager().getPieceAt((int) getCurrentPosition().getX() + 2, (int) getCurrentPosition().getY() + 1).getOwner() != getOwner()) {
            list.add(new Point2D(getCurrentPosition().getX() + 2, getCurrentPosition().getY() + 1));
         }

      }


      return list;
   }
}
