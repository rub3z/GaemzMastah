package mazeGame;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import mazeGame.controller.Controller;
import mazeGame.model.Direction;
import mazeGame.model.Maze;
import mazeGame.model.Player;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("view/mainView.fxml"));
		Parent root = (Parent) loader.load();
		Controller controller = loader.getController();
		Scene scene = new Scene(root, 800, 600);
		primaryStage.setTitle("Maze Game");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent keyEvent) {

				switch (keyEvent.getCode()) {
				case UP:
					controller.move(Direction.North);
					break;
				case DOWN:
					controller.move(Direction.South);
					break;
				case LEFT:
					controller.move(Direction.West);
					break;
				case RIGHT:
					controller.move(Direction.East);
					break;
				default:
					break;
				}
			}
		});

	}
}
