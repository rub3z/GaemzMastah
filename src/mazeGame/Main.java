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
		Controller controller=loader.getController();
		primaryStage.setTitle("Maze Game");
		primaryStage.setScene(new Scene(root, 800, 600));
		primaryStage.show();
		primaryStage.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent keyEvent) {

				boolean canMove = false;
				switch (keyEvent.getCode()) {
				case UP:
					System.out.println(keyEvent.getCode());
					canMove = controller.move(Direction.North);
					break;
				case DOWN:
					System.out.println(keyEvent.getCode());
					canMove = controller.move(Direction.South);
					break;
				case LEFT:
					System.out.println(keyEvent.getCode());
					canMove = controller.move(Direction.West);
					break;
				case RIGHT:
					System.out.println(keyEvent.getCode());
					canMove = controller.move(Direction.East);
					break;
				default:
					break;
				}
			}
		});

	}
}
