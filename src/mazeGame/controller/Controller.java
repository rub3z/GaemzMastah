package mazeGame.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import mazeGame.view.ResizableCanvas;

public class Controller implements Initializable{
	@FXML private ResizableCanvas maze;
	@FXML private StackPane holder;
	private GraphicsContext gc;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Maze holder setting
		holder.setStyle("-fx-background-color: white");
		holder.setPrefWidth(400);
		holder.setPrefHeight(400);
		
		gc=maze.getGraphicsContext2D();
		drawMaze(gc);
		
	}
	public void drawMaze(GraphicsContext gc) {
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(1);
        gc.strokeLine(0, 0, 10, 0);
	}
}
