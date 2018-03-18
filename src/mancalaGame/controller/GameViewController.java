package mancalaGame.controller;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import mancalaGame.model.Marble;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;

public class GameViewController implements Initializable {
    @FXML
    private Button pot0, pot1, pot2, pot3, pot4, pot5, pot6, pot7, pot8, pot9, pot10, pot11, pot12, pot13;
    @FXML
    private Label info0, info1, info2, info3, info4, info5, info6, info7, info8, info9, info10, info11, info12, info13;

    private MainViewController mainViewController;
    private ArrayList<Button> potList;
    private ArrayList<Label> infoList;
    private ArrayList<Marble> mableList;
    private ArrayList<TranslateTransition> translateTransitionsList;
    private Random random;
    private Bounds potSceenBound;
    private boolean isAnimation = false;

    public GameViewController() {
        potList = new ArrayList<Button>();
        infoList = new ArrayList<Label>();
        random = new Random();
        mableList = new ArrayList<Marble>();
        translateTransitionsList = new ArrayList<>();
    }


    public void addMarble(Marble marble) {
        ((GridPane) pot0.getParent().getParent()).getChildren().add(marble);

    }

    public void moveMarble(int marbleIndex, int potIndex) {
        potList.get(potIndex).setDisable(false);
        Marble marble = mableList.get(marbleIndex);
        potSceenBound = potList.get(potIndex).getParent().localToScreen(potList.get(potIndex).getBoundsInLocal());
        double minX = potSceenBound.getMinX();
        double maxX = potSceenBound.getMaxX() - 100;
        double minY = potSceenBound.getMinY();
        double maxY = potSceenBound.getMaxY() - 300;
        double n = (double) random.nextInt(11) + 95;
        n = n / 100;
        double x = (((maxX - minX) / 2) + minX);
        n = (double) random.nextInt(31) + 85;
        n = n / 100;
        double y = (((maxY - minY) / 2) + minY) * n;
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.seconds(0.1));
        translateTransition.setNode(marble);
        translateTransition.setToX(x);
        translateTransition.setToY(y);
        translateTransitionsList.add(translateTransition);
        translateTransition.setOnFinished(e -> {
            if (translateTransitionsList.size() > 0) {

                translateTransitionsList.remove(0).play();
            } else {
                isAnimation = false;

            }
        });
        if (isAnimation == false && translateTransitionsList.size() > 0) {
            isAnimation = true;
            translateTransitionsList.remove(0).play();
        }
    }

    public void adjustInfo(int infoIndex, int value) {
        infoList.get(infoIndex).setText(Integer.toString(value));
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        potList.addAll(Arrays.asList(pot0, pot1, pot2, pot3, pot4, pot5, pot6, pot7, pot8, pot9, pot10, pot11, pot12, pot13));
        infoList.addAll(Arrays.asList(info0, info1, info2, info3, info4, info5, info6, info7, info8, info9, info10, info11, info12, info13));

        while (mableList.size() < 48) {
            Marble marble = new Marble();
            mableList.add(marble);
            addMarble(marble);
        }

        setMouseClick();
    }

    public void setMainViewController(MainViewController mainViewController) {
        this.mainViewController = mainViewController;
    }

    public void setMouseClick() {
        pot0.setOnMouseClicked(e -> {
            mainViewController.gameLogic(0);
        });
        pot1.setOnMouseClicked(e -> {
            mainViewController.gameLogic(1);
        });
        pot2.setOnMouseClicked(e -> {
            mainViewController.gameLogic(2);
        });
        pot3.setOnMouseClicked(e -> {
            mainViewController.gameLogic(3);
        });
        pot4.setOnMouseClicked(e -> {
            mainViewController.gameLogic(4);
        });
        pot5.setOnMouseClicked(e -> {
            mainViewController.gameLogic(5);
        });


    }

    public ArrayList<Button> getPotList() {
        return potList;
    }


}
