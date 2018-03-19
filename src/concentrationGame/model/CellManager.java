package concentrationGame.model;

import java.util.ArrayList;
import java.util.List;

public class CellManager {
   /**
    * List of all cell. Must keep in sync with view.
    */
   ArrayList<Cell> list;


   public CellManager(){
      list=new ArrayList<>();
      createCell();
   }

   /**
    * Create cells
    */
   public void createCell(){
      list.clear();
      list.add(new Cell(true,false,0,"concentrationGame/resources/1.png"));
      list.add(new Cell(true,false,0,"concentrationGame/resources/1.png"));
      list.add(new Cell(true,false,0,"concentrationGame/resources/1.png"));
      list.add(new Cell(true,false,0,"concentrationGame/resources/1.png"));
      list.add(new Cell(true,false,0,"concentrationGame/resources/1.png"));
   }

   /**
    * Use to get list of cell which will then be use for to create view.
    * @return
    */
   public List<Cell> getList(){
      return list;
   }

   /**
    * Use to compare the two cells together.
    * @param i Index of the first cell.
    * @param y Index of the second cell.
    * @return true: if cell is match updateFlipped; else false;
    */
   public boolean isMatch(int i, int y){


      return false;
   }


}
