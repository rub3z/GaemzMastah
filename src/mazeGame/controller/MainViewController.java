package mazeGame.controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import mazeGame.model.Cell;
import mazeGame.model.Direction;
import mazeGame.model.Maze;
import mazeGame.model.Player;


public class MainViewController {
    @FXML
    GameViewController gameViewController;
    @FXML
    UIController uiController;

    private Maze maze;
    private Cell[][] mazeMap;
    private Player player;

    public MainViewController() {

        maze = new Maze(50, 50);
    }

    @FXML
    public void initialize() {
        gameViewController.setMainViewController(this);
        uiController.setMainViewController(this);
        startNewGame();
    }

    public void startNewGame() {
        mazeMap = maze.getMaze();
        player = new Player((int) maze.getStart().getX(), (int) maze.getStart().getY());
        gameViewController.drawMap(mazeMap, new Point2D(maze.getStart().getX(), maze.getStart().getY()), new Point2D(maze.getEnd().getX(), maze.getEnd().getY()));
        gameViewController.drawPlayer(new Point2D(player.getX(), player.getY()));


    }

    public boolean move(Direction d) {
        boolean result = maze.movePlayer(player, d);
        if (result == true) {
            gameViewController.drawPlayer(new Point2D(player.getX(), player.getY()));
            won();
        }
        return result;

    }

    public void addKeyboardControl(Scene scene) {
        scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()) {
                    case UP:
                        move(Direction.North);
                        break;
                    case DOWN:
                        move(Direction.South);
                        break;
                    case LEFT:
                        move(Direction.West);
                        break;
                    case RIGHT:
                        move(Direction.East);
                        break;
                    default:
                        break;
                }
                keyEvent.consume();
            }
        });
    }

    public void rePlay() {
        gameViewController.clearCanvas();
        startNewGame();
    }

    public void close() {
        Stage stage = (Stage) gameViewController.getScrollPanel().getScene().getWindow();
        gameViewController.clearCanvas();
        stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));

    }

    public void won() {
        if (player.getX() == maze.getEnd().getX() && player.getY() == maze.getEnd().getY()) {
            displayEndGameScreen();
        }
    }

    public void displayEndGameScreen() {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mazeGame/view/EndgameScreen.fxml"));
            Parent root = fxmlLoader.load();
            EndgameScreenController endgameScreenController = fxmlLoader.getController();
            endgameScreenController.setMainViewController(this);
            endgameScreenController.result("Won");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("End");
            stage.setMaximized(false);
            stage.initOwner(gameViewController.getScrollPanel().getScene().getWindow());
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
