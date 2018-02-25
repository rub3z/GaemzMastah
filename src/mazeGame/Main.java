package mazeGame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("view/mainView.fxml"));
	    Parent root = (Parent) loader.load();
		primaryStage.setTitle("Maze Game");
		primaryStage.setScene(new Scene(root, 800,600));
		primaryStage.show();
	}

}
