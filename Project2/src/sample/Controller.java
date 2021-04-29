package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;



public class Controller {
    public TextField txtTimerName;
    public TextField txtTimerLength;
    public Button btnCancelTimer;
    public Button btnCreateTimer;
    public ListView timersList;
    public Label lblTimerAlert;


    @FXML
    public void initialize(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
            updateUI();
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        /*Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, 1000);*/
    }

    public void cancelTimer(ActionEvent actionEvent) {
    MyTimer subject;
        subject = (MyTimer)timersList.getSelectionModel().getSelectedItem();
        timersList.getItems().remove(subject);
        btnCancelTimer.setDisable(true);
    }

    public void createTimer(ActionEvent actionEvent) {
        timersList.getItems().add(new MyTimer(txtTimerName.getText(), Integer.parseInt(txtTimerLength.getText())));
        txtTimerName.clear();
        txtTimerLength.clear();
    }

    public void updateUI() {
        ObservableList<MyTimer> myList = timersList.getItems();
        //timersList.getItems().clear();
        for (MyTimer t : myList) {
            t.decrement();
            System.out.println(t.timeLeft);
        }
        timersList.refresh();
    }
    TimerTask timerTask = new TimerTask()
    {
        public void run()
        {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    updateUI();
                }
            });
        }
    };
}
