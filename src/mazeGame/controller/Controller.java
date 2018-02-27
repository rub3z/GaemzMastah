package mazeGame.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import mazeGame.model.Cell;
import mazeGame.model.Direction;
import mazeGame.model.Maze;
import mazeGame.model.Player;
import mazeGame.model.ResizableCanvas;

public class Controller implements Initializable{
	@FXML
	private Canvas mazeDrawable;
	@FXML
	private Canvas playerDrawable;
	@FXML
	private StackPane holder;
	private GraphicsContext gcMazeDrawable;
	private GraphicsContext gcPlayerDrawable;
	private Maze maze;
	private Cell[][] mazeMap;
	private Player player;
	private double scale = 25;
	
	public void drawMaze() {
		gcMazeDrawable.setStroke(Color.BLACK);
		gcMazeDrawable.setLineWidth(2);

		for (int i = 0; i < mazeMap.length; i++) {
			for (int j = 0; j < mazeMap[i].length; j++) {

				// East
				if (mazeMap[i][j].getSide(Direction.East))
					gcMazeDrawable.strokeLine((mazeMap[i][j].getX() + 1) * scale, mazeMap[i][j].getY() * scale,
							(mazeMap[i][j].getX() + 1) * scale, (mazeMap[i][j].getY() + 1) * scale);
				// West
				if (mazeMap[i][j].getSide(Direction.West))
					gcMazeDrawable.strokeLine(mazeMap[i][j].getX() * scale, mazeMap[i][j].getY() * scale,
							mazeMap[i][j].getX() * scale, (mazeMap[i][j].getY() + 1) * scale);
				// North
				if (mazeMap[i][j].getSide(Direction.North))
					gcMazeDrawable.strokeLine(mazeMap[i][j].getX() * scale, mazeMap[i][j].getY() * scale,
							(mazeMap[i][j].getX() + 1) * scale, mazeMap[i][j].getY() * scale);
				// South
				if (mazeMap[i][j].getSide(Direction.South))
					gcMazeDrawable.strokeLine(mazeMap[i][j].getX() * scale, (mazeMap[i][j].getY() + 1) * scale,
							(mazeMap[i][j].getX() + 1) * scale, (mazeMap[i][j].getY() + 1) * scale);

			}
		}

		gcMazeDrawable.fillText("S", (maze.getStart().getX()+0.4) * scale, (maze.getStart().getY()+0.65) * scale);
		gcMazeDrawable.fillText("E", (maze.getEnd().getX()+0.4) * scale, (maze.getEnd().getY()+0.65) * scale);
		drawPlayer();
	}

	public void drawPlayer() {
		gcPlayerDrawable.clearRect(0, 0, playerDrawable.getWidth(), playerDrawable.getHeight());
		gcPlayerDrawable.fillOval((player.getX()+0.35) * scale, (player.getY()+0.30) * scale, 10, 10);
	}

	public boolean move(Direction d) {
		boolean result=maze.movePlayer(player, d);
		if(result==true) {
			drawPlayer();
		}
		return result;

	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		holder.setStyle("-fx-background-color: white");
		holder.setPrefWidth(1920);
		holder.setPrefHeight(1080);
		gcMazeDrawable = mazeDrawable.getGraphicsContext2D();
		gcPlayerDrawable=playerDrawable.getGraphicsContext2D();
		drawMaze();
		
	}
	public Controller() {
		maze = new Maze(25, 25);
		mazeMap = maze.getMaze();
		player = new Player((int) maze.getStart().getX(), (int) maze.getStart().getY());
	}


}
