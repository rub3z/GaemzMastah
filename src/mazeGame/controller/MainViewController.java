package mazeGame.controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
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
}
