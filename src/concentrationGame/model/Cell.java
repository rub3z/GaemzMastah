package concentrationGame.model;

public class Cell {

   /**
    * Can the cell be flip anymore. NO if its pair is found.
    */
   private boolean canFlip;

   /**
    * Is the cell current showing
    */
   private boolean isFlipped;

   /**
    * Unique ID in which cell is compared to its partner.
    */
   private int id;

   /**
    * Relative path of the image.
    */
   private String path;

   /**
    * Default Constructor
    */
   public Cell(){
      canFlip=true;
      isFlipped=false;
      id=-1;
      path="concentrationGame/resources/1.png";
   }

   /**
    * Overload construction
    * @param canFlip Can cell be flip?
    * @param isFlipped Is cell flipped on its face?
    * @param id   What is the ID of cell?
    * @param path Relative path to cell image.
    */
   public Cell(boolean canFlip, boolean isFlipped, int id, String path){
      this.canFlip=canFlip;
      this.isFlipped=isFlipped;
      this.id=id;
      this.path=path;
   }


   /**
    * Get image path of this cell
    * @return relative path
    */
   public String getPath(){
      return path;
   }


}
