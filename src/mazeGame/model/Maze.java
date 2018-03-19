package mazeGame.model;

import java.util.Random;

public class Maze {
   private int column, row;
   private Cell[][] maze;
   private Random rnd;
   private Cell start, end;

   public Maze() {
      this.column = 10;
      this.row = 10;
      initialize();
   }

   public Maze(int column, int row) {
      this.column = column;
      this.row = row;
      initialize();

   }

   private void initialize() {
      maze = new Cell[row][column];
      rnd = new java.util.Random();

   }

   public Cell[][] getMaze() {

      for (int i = 0; i < column; i++) {
         for (int j = 0; j < row; j++) {
            maze[j][i] = new Cell(i, j, false, false, false, false);
            if (j == 0) {
               maze[j][i].setSide(true, Direction.North);
            }
            if (j == row - 1) {
               maze[j][i].setSide(true, Direction.South);
            }
            if (i == 0) {
               maze[j][i].setSide(true, Direction.West);
            }
            if (i == column - 1) {
               maze[j][i].setSide(true, Direction.East);
            }
         }
      }
      generateMaze(0, 0, column - 1, row - 1);
      initializeStartEnd();
      return maze;
   }

   private void generateMaze(int x1, int y1, int x2, int y2) {
      int value = rnd.nextInt(2);
      // Horizontal divide
      if (value == 0) {
         if (y1 < y2) {
            int middle = ((y2 - y1) / 2) + y1;
            for (int i = x1; i <= x2; i++) {
               maze[middle][i].setSide(true, Direction.South);
               maze[middle + 1][i].setSide(true, Direction.North);

            }
            int gate = rnd.nextInt(x2 - x1 + 1) + x1;

            maze[middle][gate].setSide(false, Direction.South);
            maze[middle + 1][gate].setSide(false, Direction.North);
            generateMaze(x1, y1, x2, middle);
            generateMaze(x1, middle + 1, x2, y2);
         }
      }

      // Vertical divide
      if (value == 1) {
         if (x1 < x2) {
            int middle = ((x2 - x1) / 2) + x1;
            for (int i = y1; i <= y2; i++) {
               maze[i][middle].setSide(true, Direction.East);
               maze[i][middle + 1].setSide(true, Direction.West);
            }
            int gate = rnd.nextInt(y2 - y1 + 1) + y1;

            maze[gate][middle].setSide(false, Direction.East);
            maze[gate][middle + 1].setSide(false, Direction.West);

            generateMaze(x1, y1, middle, y2);
            generateMaze(middle + 1, y1, x2, y2);
         }
      }
   }

   private void initializeStartEnd() {

      int choice = rnd.nextInt(4);
      // exit
      switch (choice) {
         // North
         case 1:
            start = maze[0][rnd.nextInt(column)];
            end = maze[row - 1][rnd.nextInt(column)];
            break;
         // West
         case 2:
            start = maze[rnd.nextInt(row)][0];
            end = maze[rnd.nextInt(row)][column - 1];
            break;
         // East
         case 3:
            start = maze[rnd.nextInt(row)][column - 1];
            end = maze[rnd.nextInt(row)][0];
            break;
         // South
         default:
            start = maze[row - 1][rnd.nextInt(column)];
            end = maze[0][rnd.nextInt(column)];
            break;
      }
   }

   public Cell getStart() {
      return start;

   }

   public Cell getEnd() {
      return end;

   }

   public boolean movePlayer(Player p, Direction d) {
      boolean canMove = !maze[p.getY()][p.getX()].getSide(d);
      if (canMove == false) {
         return false;
      } else {
         switch (d) {
            case North:
               p.movePlayerTo(p.getX(), p.getY() - 1);
               break;
            case South:
               p.movePlayerTo(p.getX(), p.getY() + 1);
               break;
            case East:
               p.movePlayerTo(p.getX() + 1, p.getY());
               break;
            default:
               p.movePlayerTo(p.getX() - 1, p.getY());
               break;
         }
         return true;
      }

   }

   public void printMaze() {
      for (int i = 0; i < column; i++) {
         for (int j = 0; j < row; j++) {
            System.out.println(maze[j][i].toString());
         }
      }
   }
}
