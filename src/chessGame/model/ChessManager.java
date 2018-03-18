package chessGame.model;

import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.List;

public class ChessManager {
    final int size = 6;
    private GenericChessPiece[][] board;
    private ArrayList<ChessPieceType> player0, player1;
    private int turn;

    public ChessManager() {
        board = new GenericChessPiece[size][size];
        start();
        player0 = new ArrayList<>();
        player1 = new ArrayList<>();
        turn = 1;
    }

    public void start() {
        clearBoard();
        initializeBoard();

    }

    private void clearBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = null;
            }
        }
    }

    private void initializeBoard() {
        //Black
        //Pawn
        for (int i = 0; i < board[0].length; i++) {
            board[1][i] = new Pawn(i, 1, 0);
        }
        //Rook
        board[0][0] = new Rook(0, 0, 0);
        board[0][board[0].length - 1] = new Rook(board[0].length - 1, 0, 0);
        //Knight
        board[0][1] = new Knight(1, 0, 0);
        board[0][board[0].length - 2] = new Knight(board[0].length - 2, 0, 0);
        //Bishop
        board[0][2] = new Bishop(2, 0, 0);
        board[0][board[0].length - 3] = new Bishop(board[0].length - 3, 0, 0);


        //White
        //Pawn
        for (int i = 0; i < board[0].length; i++) {
            board[size - 2][i] = new Pawn(i, size - 2, 1);
        }
        //Rook
        board[size - 1][0] = new Rook(0, size - 1, 1);
        board[size - 1][board[0].length - 1] = new Rook(board[0].length - 1, size - 1, 1);
        //Knight
        board[size - 1][1] = new Knight(1, size - 1, 1);
        board[size - 1][board[0].length - 2] = new Knight(board[0].length - 2, size - 1, 1);
        //Bishop
        board[size - 1][2] = new Bishop(2, size - 1, 1);
        board[size - 1][board[0].length - 3] = new Bishop(board[0].length - 3, size - 1, 1);
        addManagerToAllPiece();
    }

    private void printBoard() {
        System.out.println("----------------------------------------------------");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[j][i] != null)
                    System.out.println(board[j][i].getType() + " " + board[j][i].getOwner());
            }

        }
        System.out.println("----------------------------------------------------");
    }

    public List<Point2D> getAvailableMove(int x, int y) {
        return board[y][x].availableMove(size);
    }

    public List<Point2D> getAvailableCapture(int x, int y) {
        return board[y][x].availableCapture(size);
    }

    public int move(int x1, int y1, int x2, int y2) {

        //Capture
        for (Point2D point2D : board[y1][x1].availableCapture(size)) {
            if (point2D.getX() == x2 && point2D.getY() == y2) {
                if (board[y2][x2].getOwner() == 0) {
                    player1.add(board[y2][x2].getType());
                } else {
                    player0.add(board[y2][x2].getType());
                }
                board[y1][x1].move(new Point2D(x2, y2));
                board[y2][x2] = board[y1][x1];
                board[y1][x1] = null;
                return 2;
            }
        }
        //Move
        for (Point2D point2D : board[y1][x1].availableMove(size)) {
            if (point2D.getX() == x2 && point2D.getY() == y2) {
                board[y1][x1].move(new Point2D(x2, y2));
                board[y2][x2] = board[y1][x1];
                board[y1][x1] = null;
                return 1;
            }
        }
        return 0;

    }

    private void addManagerToAllPiece() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != null) {
                    board[i][j].setManager(this);
                }
            }
        }
    }

    public GenericChessPiece getPieceAt(int x, int y) {
        return board[y][x];
    }

    public boolean isThereAPieceAt(int x, int y) {
        return board[y][x] != null;
    }

    public void promotion(ChessPieceType type, int x, int y) {
        GenericChessPiece genericChessPieces = board[y][x];
        switch (type) {
            case QUEEN:
                board[y][x] = new Queen(x, y, genericChessPieces.getOwner());
                break;
            case ROOK:
                board[y][x] = new Rook(x, y, genericChessPieces.getOwner());
                break;
            case BISHOP:
                board[y][x] = new Bishop(x, y, genericChessPieces.getOwner());
                break;
            case KNIGHT:
                board[y][x] = new Knight(x, y, genericChessPieces.getOwner());
                break;
            default:
                board[y][x] = new Queen(x, y, genericChessPieces.getOwner());
                break;
        }
        board[y][x].setManager(this);
    }

    public List<ChessPieceType> getPlayer(int i) {
        if (i == 0) {
            return player0;
        } else {
            return player1;
        }
    }

    public int getSize() {
        return size;
    }

    public int checkWin() {
        int k = -1;
        //Check for white win aka search for black bishop
        loop0:
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                k = 1;
                if (board[j][i] != null && board[j][i].getType() == ChessPieceType.ROOK && board[j][i].getOwner() == 0) {
                    k = -1;
                    break loop0;
                }
            }
        }
        if (k == 1) {
            return k;
        }
        //Check for black win
        loop1:
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                k = 0;
                if (board[j][i] != null && board[j][i].getType() == ChessPieceType.ROOK && board[j][i].getOwner() == 1) {
                    k = -1;
                    break loop1;
                }
            }
        }

        return k;
    }

    public void switchTurn() {
        if (turn == 0) {
            turn = 1;
        } else {
            turn = 0;
        }
    }

    public int getTurn() {
        return turn;
    }

    public List<ChessPieceType> getRemainingPieces(int owner) {
        ArrayList<ChessPieceType> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[j][i] != null && board[j][i].getOwner() == owner) {
                    list.add(board[j][i].getType());
                }
            }
        }
        return list;
    }

    public List<ChessPieceType> getCapturedPieces(int owner) {
        if (owner == 0) {
            return player0;
        } else {
            return player1;
        }

    }
}
