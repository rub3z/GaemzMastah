package launcher.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.FlowPane;
import launcher.model.Program;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class GameListController {
   MainViewController parentController;
   @FXML
   private FlowPane gameList;

   public void setMainViewController(MainViewController mainViewController) {
      parentController = mainViewController;
   }

   public void addAppsToView(ArrayList<Program> appList) {
      try {
         System.out.println(appList.size());
         for (int i = 0; i < appList.size(); i++) {
            Program p = appList.get(i);
            Button button = new Button(p.getTitle());
            button.setStyle("-fx-background-image: url(" + p.getIconPath() + ")");
            Class myClass = Class.forName(p.getPath());
            Constructor intConstructor = myClass.getConstructor();
            button.setOnAction(event -> {
               try {
                  intConstructor.newInstance();
               } catch (Exception e) {
                  e.printStackTrace();
               }
            });
            button.setContentDisplay(ContentDisplay.TOP);
            gameList.getChildren().add(button);
         }
      } catch (Exception e) {
         e.printStackTrace();
      }

   }
}
