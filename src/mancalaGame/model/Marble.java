package mancalaGame.model;

import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Marble extends Circle {
    private Timeline timeline;
    public Marble(){
        setCenterX(0);
        setCenterY(0);
        setRadius(40);
        Stop[] stops = new Stop[] { new Stop(0, Color.color(Math.random(),Math.random(),Math.random())), new Stop(1, Color.color(Math.random(),Math.random(),Math.random()))};
        LinearGradient lg1 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.REFLECT, stops);
        setFill(lg1);
        timeline=new Timeline();
        timeline.setAutoReverse(false);
        timeline.setCycleCount(1);
    }
    public Timeline getTimeline(){
        return timeline;
    }

}
