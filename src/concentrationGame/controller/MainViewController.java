package concentrationGame.controller;

import concentrationGame.model.Cell;
import concentrationGame.model.CellManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

   /**
    * Game view controller
    */
   @FXML
   private GameViewController gameViewController;

   /**
    * Stage aka windows of the application.
    */
   private Stage stage;

   /**
    * Manager of all cell
    */
   private CellManager cellManager;

   /**
    * Constructor
    */
   public MainViewController(){
      cellManager=new CellManager();
   }

   /**
    * Called to initialize a controller after its root element has been
    * completely processed.
    *
    * @param location  The location used to resolve relative paths for the root object, or
    *                  <tt>null</tt> if the location is not known.
    * @param resources The resources used to localize the root object, or <tt>null</tt> if
    */
   @Override
   public void initialize(URL location, ResourceBundle resources) {
      gameViewController.setMainViewController(this);
   }

   /**
    * Set Stage
    * @param stage
    */
   public void setStage(Stage stage){
      this.stage=stage;
   }


   /**
    * Method to initialize the variable for the application.
    */
   public void start(){
    for(Cell c:cellManager.getList()){
       gameViewController.createCells(c.getPath());
    }
   }


}
