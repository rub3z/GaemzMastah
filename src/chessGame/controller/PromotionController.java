package chessGame.controller;

import chessGame.model.ChessPieceType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PromotionController implements Initializable {
    @FXML
    private Button button0, button1, button2;

    private MainViewController mainViewController;
    private int targetX, targetY;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button0.setOnMouseClicked(event -> {
            mainViewController.promotion(ChessPieceType.ROOK, targetX, targetY);
            Stage stage = (Stage) button0.getScene().getWindow();
            stage.close();
        });
        button1.setOnMouseClicked(event -> {
            mainViewController.promotion(ChessPieceType.BISHOP, targetX, targetY);
            Stage stage = (Stage) button0.getScene().getWindow();
            stage.close();
        });
        button2.setOnMouseClicked(event -> {
            mainViewController.promotion(ChessPieceType.KNIGHT, targetX, targetY);
            Stage stage = (Stage) button0.getScene().getWindow();
            stage.close();
        });

    }

    public void setMainViewController(MainViewController mainViewController) {
        this.mainViewController = mainViewController;
    }

    public void setStyle(int owner) {
        if (owner == 0) {
            button0.getStyleClass().add("rook0");
            button1.getStyleClass().add("bishop0");
            button2.getStyleClass().add("knight0");
        } else {
            button0.getStyleClass().add("rook1");
            button1.getStyleClass().add("bishop1");
            button2.getStyleClass().add("knight1");
        }
    }

    public void setTarget(int x, int y) {
        targetX = x;
        targetY = y;
    }
}
