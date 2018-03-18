package chessGame.controller;

import chessGame.model.ChessPieceType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class EndgameScreenController implements Initializable {
    @FXML
    private Label displayText;
    @FXML
    private ListView whiteRemaining, blackRemaining, whiteCaptured, blackCaptured;
    @FXML
    private Button playAgain, exit;

    private MainViewController mainViewController;

    public void updateData(List<ChessPieceType> whiteRemaining, List<ChessPieceType> blackRemaining, List<ChessPieceType> whiteCaptured, List<ChessPieceType> blackCaptured) {
        ObservableList<ChessPieceType> wR = FXCollections.observableArrayList(whiteRemaining);
        ObservableList<ChessPieceType> bR = FXCollections.observableArrayList(blackRemaining);
        ObservableList<ChessPieceType> wC = FXCollections.observableArrayList(whiteCaptured);
        ObservableList<ChessPieceType> bC = FXCollections.observableArrayList(blackCaptured);
        this.whiteRemaining.setItems(wR);
        this.blackRemaining.setItems(bR);
        this.whiteCaptured.setItems(wC);
        this.blackCaptured.setItems(bC);

    }

    public void updateWinner(int winner) {
        if (winner == 0) {
            displayText.setText("Black is Victorious!!!");
        } else {
            displayText.setText("White is Victorious!!!");
        }
    }

    public void setMainViewController(MainViewController mainViewController) {
        this.mainViewController = mainViewController;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        playAgain.setOnMouseClicked(event -> {
            mainViewController.restart();
            Stage stage = (Stage) playAgain.getScene().getWindow();
            stage.close();
        });
        exit.setOnMouseClicked(event -> {
            mainViewController.close();
            Stage stage = (Stage) playAgain.getScene().getWindow();
            stage.close();
        });
    }
}
