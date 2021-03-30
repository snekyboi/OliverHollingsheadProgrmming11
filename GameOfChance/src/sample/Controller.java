package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class Controller {
    public Label lblMoneyCount;
    public Label lblCroupRoll;
    public Label lblYourRoll;
    public Button btnHigher;
    public Button btnLower;
    public Button btnNewGame;
    private int moneyCount = 100;
    int croupierRoll = (int)(Math.random()*6+1);

    @FXML
    public void initialize() {
        lblMoneyCount.setText("Your money: $" + moneyCount);
        btnHigher.setDisable(true);
        btnLower.setDisable(true);
        lblCroupRoll.setText("");
        lblYourRoll.setText("");
    }



    public void croupRoll(ActionEvent actionEvent) {
        croupierRoll = (int)(Math.random()*6+1);
        lblCroupRoll.setText(String.valueOf(croupierRoll));
        btnLower.setDisable(false);
        btnHigher.setDisable(false);
        btnNewGame.setDisable(true);
        lblYourRoll.setText("");
    }

    public void youRollHigher(ActionEvent actionEvent) {
        int yourRollHigher = (int)(Math.random()*6+1);
        lblYourRoll.setText(String.valueOf(yourRollHigher));
        btnLower.setDisable(true);
        btnHigher.setDisable(true);
        btnNewGame.setDisable(false);
        if (yourRollHigher > croupierRoll){
            moneyCount++;
        }
        else {
            moneyCount--;
        }
        lblMoneyCount.setText("Your money: $" + moneyCount);
    }

    public void youRollLower(ActionEvent actionEvent) {
        int yourRollLower = (int)(Math.random()*6+1);
        lblYourRoll.setText(String.valueOf(yourRollLower));
        btnLower.setDisable(true);
        btnHigher.setDisable(true);
        btnNewGame.setDisable(false);
        if (yourRollLower < croupierRoll){
            moneyCount++;
            lblMoneyCount.setText("Your money: $" + moneyCount);
        }
        else {
            moneyCount--;
            lblMoneyCount.setText("Your money: $" + moneyCount);
        }
    }

}
