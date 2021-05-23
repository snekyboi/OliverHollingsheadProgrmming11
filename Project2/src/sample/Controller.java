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
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TimerTask;



public class Controller {
    public TextField txtTimerName;
    public TextField txtTimerLength;
    public Button btnCancelTimer;
    public Button btnCreateTimer;
    public ListView timersList;
    public Label lblTimerAlert;
    public TextField txtAlarmName;
    public TextField txtAlarmTime;
    public ListView alarmsList;
    public Button btnCreateAlarm;
    public Button btnCancelAlarm;
    public TextField txtAlarmTimeM;
    public Label lblCurrentTime;
    public Label lblNextAlarm;
    public Label lblNextTimer;
    public Label doneAlert;
    public Label doneAlertTimer;
    private CurrentTime clock;


    @FXML
    public void initialize() throws IOException {
        clock = new CurrentTime();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
            updateUI();
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        loadAlarms();
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
        CurrentTime.updateTime();
        showTime();
        ObservableList<MyAlarm> alarms = alarmsList.getItems();
        doneAlert.setText("");
        doneAlertTimer.setText("");
        for (MyAlarm a : alarms) {
            if (CurrentTime.isDone(a)){
                doneAlert.setText("Alarm: " + a.name + " is done");
            }
        }

        ObservableList<MyTimer> myList = timersList.getItems();
        for (MyTimer t : myList) {
            t.decrement();
            if (t.isDone()){
                doneAlertTimer.setText("Timer: " + t.name + " is done");
            }
            if (t.isReallyDone()){
                doneAlertTimer.setText("");
            }
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

    public void writeAllAlarmsToFile() throws IOException  {
        FileWriter fw = new FileWriter("alarms.txt", false);
        BufferedWriter  bw = new BufferedWriter(fw);
        ObservableList<MyAlarm> allAlarms = alarmsList.getItems();
        for (MyAlarm a : allAlarms){
            a.writeToFile(bw);
        }
        bw.close();
    }
    public void createAlarm(ActionEvent actionEvent) throws IOException  {
        MyAlarm newAlarm = new MyAlarm(txtAlarmName.getText(), Integer.parseInt(txtAlarmTime.getText()), Integer.parseInt(txtAlarmTimeM.getText()));
        alarmsList.getItems().add(newAlarm);
        txtAlarmName.clear();
        txtAlarmTime.clear();
        txtAlarmTimeM.clear();
        writeAllAlarmsToFile();
    }

    public void cancelAlarm(ActionEvent actionEvent) throws IOException {
        MyAlarm subject;
            subject = (MyAlarm) alarmsList.getSelectionModel().getSelectedItem();
            alarmsList.getItems().remove(subject);
            btnCancelAlarm.setDisable(true);
            writeAllAlarmsToFile();
    }

    public void showTime(){
        lblCurrentTime.setText(CurrentTime.toStringTime());
    }

    public void saveAlarm(ActionEvent actionEvent) throws IOException {
        ObservableList<MyAlarm> myList = alarmsList.getItems();
        FileWriter fw = new FileWriter("alarms.txt", false);
        BufferedWriter bw = new BufferedWriter(fw);
        for (MyAlarm a : myList){
            a.writeToFile(bw);
        }
        bw.close();
    }

    public void loadAlarms() throws IOException {
        ArrayList<MyAlarm> friends = LoadAlarms.createAllAlarms("alarms.txt");
        for (MyAlarm f : friends){
            alarmsList.getItems().add(f);
        }
    }
    public void unDisableDltAlarm(MouseEvent mouseEvent) {
        btnCancelAlarm.setDisable(false);
    }

    public void unDisableDltTimer(MouseEvent mouseEvent) {
        btnCancelTimer.setDisable(false);
    }
}
