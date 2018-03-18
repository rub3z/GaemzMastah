package mancalaGame.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import mancalaGame.model.Pot;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {
    @FXML
    private GameViewController gameViewController;
    @FXML
    private UIController uiController;

    private ArrayList<Pot> potList;
    private Random random;
    private boolean playerCanPlayAgain;
    private boolean aiCanPlayAgain;
    private boolean isPlayerTurn;

    public MainViewController() {
        playerCanPlayAgain = false;
        aiCanPlayAgain = false;
        isPlayerTurn = true;
        random = new Random();
        int j = 0;
        potList = new ArrayList<Pot>();
        for (int i = 0; i < 14; i++) {
            potList.add(new Pot());
        }
        for (int i = 0; i < potList.size(); i++) {
            if (i != 6 && i != 13) {
                while (potList.get(i).size() < 4) {
                    potList.get(i).add(j);
                    j++;
                }
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gameViewController.setMainViewController(this);

    }

    public void start() {
        distribute();
        resetInfo();
    }

    private void distribute() {
        for (int i = 0; i < potList.size(); i++) {
            ArrayList<Integer> pot = potList.get(i).getPot();
            for (int j = 0; j < pot.size(); j++) {
                gameViewController.moveMarble(pot.get(j), i);
            }
        }
    }

    public void play(int i) {
        ArrayList<Integer> pot = potList.get(i).getPot();
        gameViewController.getPotList().get(i).setDisable(true);
        int m = (i + pot.size()) % 14;
        int j = i + 1;
        for (int l = pot.size(); l > 0; l--) {
            if (j > 13) {
                j = 0;
            }
            if (isPlayerTurn && j == 13) {
                j = 0;
            }
            if (!isPlayerTurn && j == 6) {
                j++;
            }
            int k = pot.remove(0);
            potList.get(j).getPot().add(k);
            gameViewController.moveMarble(k, j);
            j++;
        }
        if (m == 6) {
            playerCanPlayAgain = true;
        }
        if (m == 13) {
            aiCanPlayAgain = true;
        }

        if (potList.get(m).size() == 0 && m != 13 && m != 6 && ((m < 6 && m > 0 && isPlayerTurn) || (m > 6 && m < 13 && !isPlayerTurn))) {
            while (potList.get(12 - m).getPot().size() > 0) {
                int k = potList.get(12 - i + pot.size()).getPot().remove(0);
                if (m < 6 && isPlayerTurn) {
                    potList.get(6).add(k);
                    gameViewController.moveMarble(k, 6);
                } else if (m < 13 && !isPlayerTurn) {
                    potList.get(13).add(k);
                    gameViewController.moveMarble(k, 13);
                }
            }
        }

        resetInfo();
        won();
    }

    private void resetInfo() {
        for (int i = 0; i < potList.size(); i++) {
            gameViewController.adjustInfo(i, potList.get(i).size());
        }
    }

    private void won() {
        if (potList.get(6).size() + potList.get(13).size() == 48) {
            displayEndGameScreen();
        }

    }

    public void gameLogic(int i) {
        if (playerCanPlay() && i >= 0) {

            if (playerCanPlayAgain == true) {
                playerCanPlayAgain = false;
            }
            isPlayerTurn = true;
            play(i);

        }

        if (aiCanPlay() && !playerCanPlayAgain) {
            ArrayList<Button> potList = gameViewController.getPotList();
            while (true) {
                int k = random.nextInt(6) + 7;
                if (potList.get(k).isDisable() == false) {
                    isPlayerTurn = false;
                    play(k);
                    k++;
                    break;
                }
            }
            //System.out.print(aiCanPlayAgain);
            if (!playerCanPlay() || aiCanPlayAgain) {
                aiCanPlayAgain = false;
                gameLogic(-1);
            }
        }

    }

    public boolean playerCanPlay() {
        return potList.get(0).size() + potList.get(1).size() + potList.get(2).size() + potList.get(3).size() + potList.get(4).size() + potList.get(5).size() > 0;
    }

    public boolean aiCanPlay() {
        return potList.get(7).size() + potList.get(8).size() + potList.get(9).size() + potList.get(10).size() + potList.get(11).size() + potList.get(12).size() > 0;
    }

    public void rePlay() {
        potList.clear();
        for (int i = 0; i < 14; i++) {
            potList.add(new Pot());
        }
        int j = 0;
        for (int i = 0; i < potList.size(); i++) {
            if (i != 6 && i != 13) {
                while (potList.get(i).size() < 4) {
                    potList.get(i).add(j);
                    j++;
                }
            }
        }
        start();
    }

    public void close() {
        Stage stage = (Stage) gameViewController.getPotList().get(0).getScene().getWindow();
        stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
    }

    public void displayEndGameScreen() {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mancalaGame/view/EndgameScreen.fxml"));
            Parent root = fxmlLoader.load();
            EndgameScreenController endgameScreenController = fxmlLoader.getController();
            endgameScreenController.setMainViewController(this);
            if (potList.get(6).size() > potList.get(13).size()) {
                endgameScreenController.result("Won");
            } else {
                endgameScreenController.result("Lost");
            }
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("End");
            stage.setMaximized(false);
            stage.initOwner(gameViewController.getPotList().get(0).getScene().getWindow());
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
