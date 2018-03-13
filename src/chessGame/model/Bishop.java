package FullChessGame.model;

import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends GenericChessPiece {
   public Bishop() {
      super(ChessPieceType.BISHOP, 0, 0, 0);
   }

   public Bishop(int x, int y, int owner) {
      super(ChessPieceType.BISHOP, x, y, owner);
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

      //NorthEast
      int i = 1;
      while (getCurrentPosition().getX() + i < size && getCurrentPosition().getY() - i >= 0 &&
              !getManager().isThereAPieceAt((int) getCurrentPosition().getX() + i, (int) getCurrentPosition().getY() - i)) {
         list.add(new Point2D(getCurrentPosition().getX() + i, getCurrentPosition().getY() - i));
         i++;
      }
      //NorthWest
      i = 1;
      while (getCurrentPosition().getX() - i >= 0 && getCurrentPosition().getY() - i >= 0 &&
              !getManager().isThereAPieceAt((int) getCurrentPosition().getX() - i, (int) getCurrentPosition().getY() - i)) {
         list.add(new Point2D(getCurrentPosition().getX() - i, getCurrentPosition().getY() - i));
         i++;
      }
      //SouthEast
      i = 1;
      while (getCurrentPosition().getX() + i < size && getCurrentPosition().getY() + i < size &&
              !getManager().isThereAPieceAt((int) getCurrentPosition().getX() + i, (int) getCurrentPosition().getY() + i)) {
         list.add(new Point2D(getCurrentPosition().getX() + i, getCurrentPosition().getY() + i));
         i++;
      }
      //SouthWest
      i = 1;
      while (getCurrentPosition().getX() - i >= 0 && getCurrentPosition().getY() + i < size &&
              !getManager().isThereAPieceAt((int) getCurrentPosition().getX() - i, (int) getCurrentPosition().getY() + i)) {
         list.add(new Point2D(getCurrentPosition().getX() - i, getCurrentPosition().getY() + i));
         i++;
      }
      return list;
   }

   @Override
   public List<Point2D> availableCapture(int size) {
      ArrayList<Point2D> list = new ArrayList<>();

      //NorthEast
      int i = 1;
      while (getCurrentPosition().getX() + i < size && getCurrentPosition().getY() - i >= 0) {
         if (getManager().isThereAPieceAt((int) getCurrentPosition().getX() + i, (int) getCurrentPosition().getY() - i)) {
            if (getManager().getPieceAt((int) getCurrentPosition().getX() + i, (int) getCurrentPosition().getY() - i).getOwner() != getOwner()) {
               list.add(new Point2D(getCurrentPosition().getX() + i, getCurrentPosition().getY() - i));
            }
            break;
         }
         i++;
      }
      //NorthWest
      i = 1;
      while (getCurrentPosition().getX() - i >= 0 && getCurrentPosition().getY() - i >= 0) {
         if (getManager().isThereAPieceAt((int) getCurrentPosition().getX() - i, (int) getCurrentPosition().getY() - i)) {
            if (getManager().getPieceAt((int) getCurrentPosition().getX() - i, (int) getCurrentPosition().getY() - i).getOwner() != getOwner()) {
               list.add(new Point2D(getCurrentPosition().getX() - i, getCurrentPosition().getY() - i));
            }
            break;
         }
         i++;
      }
      //SouthEast
      i = 1;
      while (getCurrentPosition().getX() + i < size && getCurrentPosition().getY() + i < size) {
         if (getManager().isThereAPieceAt((int) getCurrentPosition().getX() + i, (int) getCurrentPosition().getY() + i)) {
            if (getManager().getPieceAt((int) getCurrentPosition().getX() + i, (int) getCurrentPosition().getY() + i).getOwner() != getOwner()) {
               list.add(new Point2D(getCurrentPosition().getX() + i, getCurrentPosition().getY() + i));
            }
            break;
         }
         i++;
      }
      //SouthWest
      i = 1;
      while (getCurrentPosition().getX() - i >= 0 && getCurrentPosition().getY() + i < size) {
         if (getManager().isThereAPieceAt((int) getCurrentPosition().getX() - i, (int) getCurrentPosition().getY() + i)) {
            if (getManager().getPieceAt((int) getCurrentPosition().getX() - i, (int) getCurrentPosition().getY() + i).getOwner() != getOwner()) {
               list.add(new Point2D(getCurrentPosition().getX() - i, getCurrentPosition().getY() + i));
            }
            break;
         }
         i++;
      }
      return list;
   }
}
