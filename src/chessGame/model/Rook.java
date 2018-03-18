package chessGame.model;

import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.List;

public class Rook extends GenericChessPiece {

    public Rook() {
        super(ChessPieceType.ROOK, 0, 0, 0);
    }

    public Rook(int x, int y, int owner) {
        super(ChessPieceType.ROOK, x, y, owner);
    }


    @Override
    public void capture() {

    }

    @Override
    public void captured() {

    }

    @Override
    public List<Point2D> availableMove(int size) {
        System.out.println(getCurrentPosition());
        ArrayList<Point2D> list = new ArrayList<>();
        int i = 1;
        //North
        while
                (getCurrentPosition().getY() - i >= 0 &&
                !getManager().isThereAPieceAt((int) getCurrentPosition().getX(),
                        (int) getCurrentPosition().getY() - i)
                && i <= 2) {
            list.add(new Point2D(getCurrentPosition().getX(),
                    getCurrentPosition().getY() - i));
            i++;
        }
        //South
        i = 1;
        while
                (getCurrentPosition().getY() + i < size &&
                !getManager().isThereAPieceAt((int) getCurrentPosition().getX(),
                        (int) getCurrentPosition().getY() + i)
                && i <= 2) {
            list.add(new Point2D(getCurrentPosition().getX(),
                    getCurrentPosition().getY() + i));
            i++;
        }
        //West
        i = 1;
        while
                (getCurrentPosition().getX() - i >= 0 &&
                !getManager().isThereAPieceAt((int) getCurrentPosition().getX() - i,
                        (int) getCurrentPosition().getY())
                && i <= 2) {
            list.add(new Point2D(getCurrentPosition().getX() - i,
                    getCurrentPosition().getY()));
            i++;
        }
        //East
        i = 1;
        while
                (getCurrentPosition().getX() + i < size &&
                !getManager().isThereAPieceAt((int) getCurrentPosition().getX() + i,
                        (int) getCurrentPosition().getY())
                && i <= 2) {
            list.add(new Point2D(getCurrentPosition().getX() + i,
                    getCurrentPosition().getY()));
            i++;
        }
        return list;
    }

    @Override
    public List<Point2D> availableCapture(int size) {
        ArrayList<Point2D> list = new ArrayList<>();
        int i = 1;
        //North
        while
                (getCurrentPosition().getY() - i >= 0) {
            if (getManager()
                    .isThereAPieceAt((int) getCurrentPosition().getX(),
                            (int) getCurrentPosition().getY() - i)
                    && i <= 2) {
                if (getManager()
                        .getPieceAt((int) getCurrentPosition().getX(),
                                (int) getCurrentPosition().getY() - i)
                        .getOwner() != getOwner()) {
                    list.add(new Point2D(getCurrentPosition().getX(),
                            getCurrentPosition().getY() - i));
                }
                break;
            }
            i++;
        }
        //South
        i = 1;
        while (getCurrentPosition().getY() + i < size) {
            if (getManager()
                    .isThereAPieceAt((int) getCurrentPosition().getX(),
                            (int) getCurrentPosition().getY() + i)
                    && i <= 2) {
                if (getManager()
                        .getPieceAt((int) getCurrentPosition().getX(),
                                (int) getCurrentPosition().getY() + i)
                        .getOwner() != getOwner()) {
                    list.add(new Point2D(getCurrentPosition().getX(),
                            getCurrentPosition().getY() + i));
                }
                break;
            }
            i++;
        }
        //West
        i = 1;
        while (getCurrentPosition().getX() - i >= 0) {
            if (getManager()
                    .isThereAPieceAt((int) getCurrentPosition().getX() - i,
                            (int) getCurrentPosition().getY())
                    && i <= 2) {
                if (getManager()
                        .getPieceAt((int) getCurrentPosition().getX() - i,
                                (int) getCurrentPosition().getY())
                        .getOwner() != getOwner()) {
                    list.add(new Point2D(getCurrentPosition().getX() - i,
                            getCurrentPosition().getY()));
                }
                break;
            }
            i++;
        }
        //East
        i = 1;
        while (getCurrentPosition().getX() + i < size) {
            if (getManager()
                    .isThereAPieceAt((int) getCurrentPosition().getX() + i,
                            (int) getCurrentPosition().getY())
                    && i <= 2) {
                if (getManager()
                        .getPieceAt((int) getCurrentPosition().getX() + i,
                                (int) getCurrentPosition().getY())
                        .getOwner() != getOwner()) {
                    list.add(new Point2D(getCurrentPosition().getX() + i,
                            getCurrentPosition().getY()));
                }
                break;
            }
            i++;
        }
        return list;
    }
}
