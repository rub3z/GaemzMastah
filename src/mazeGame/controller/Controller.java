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
	private ResizableCanvas mazeDrawable;
	@FXML
	private StackPane holder;
	private GraphicsContext gc;
	private Maze maze;
	private Cell[][] mazeMap;
	private Player player;
	private double scale = 25;
	
	public void drawMaze() {
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(2);

		for (int i = 0; i < mazeMap.length; i++) {
			for (int j = 0; j < mazeMap[i].length; j++) {

				// East
				if (mazeMap[i][j].getSide(Direction.East))
					gc.strokeLine((mazeMap[i][j].getX() + 1) * scale, mazeMap[i][j].getY() * scale,
							(mazeMap[i][j].getX() + 1) * scale, (mazeMap[i][j].getY() + 1) * scale);
				// West
				if (mazeMap[i][j].getSide(Direction.West))
					gc.strokeLine(mazeMap[i][j].getX() * scale, mazeMap[i][j].getY() * scale,
							mazeMap[i][j].getX() * scale, (mazeMap[i][j].getY() + 1) * scale);
				// North
				if (mazeMap[i][j].getSide(Direction.North))
					gc.strokeLine(mazeMap[i][j].getX() * scale, mazeMap[i][j].getY() * scale,
							(mazeMap[i][j].getX() + 1) * scale, mazeMap[i][j].getY() * scale);
				// South
				if (mazeMap[i][j].getSide(Direction.South))
					gc.strokeLine(mazeMap[i][j].getX() * scale, (mazeMap[i][j].getY() + 1) * scale,
							(mazeMap[i][j].getX() + 1) * scale, (mazeMap[i][j].getY() + 1) * scale);

			}
		}
		gc.fillText("S", (maze.getStart().getX() + 0.5) * scale, (maze.getStart().getY() + 0.5) * scale);
		gc.fillText("E", (maze.getEnd().getX() + 0.5) * scale, (maze.getEnd().getY() + 0.5) * scale);
		drawPlayer();
	}

	public void drawPlayer() {
		gc.fillOval((player.getX() + 0.5) * scale, (player.getY() + 0.5) * scale, 10, 10);
	}

	public boolean move(Direction d) {
		System.out.println(player.getX()+"|"+player.getY());
		boolean result=maze.movePlayer(player, d);
		System.out.println(result);
		System.out.println(player.getX()+"|"+player.getY());
		if (result) {
			//drawPlayer();
		}
		return result;

	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		holder.setStyle("-fx-background-color: white");
		holder.setPrefWidth(1920);
		holder.setPrefHeight(1080);
		gc = mazeDrawable.getGraphicsContext2D();
		drawMaze();
		
	}
	public Controller() {
		maze = new Maze(3, 3);
		mazeMap = maze.getMaze();
		player = new Player((int) maze.getStart().getX(), (int) maze.getStart().getY());
	}


}
