package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ListView;

public class Controller {
    public TextField txtfldFriendName;
    public TextField txtfldFriendAge;
    public Button btnCreateFriend;
    public Label lblFiendName;
    public Label lblFriendAge;
    public Label lblFriendGender;
    public Button btnDeleteFriend;
    public RadioButton rbtnFemale;
    public RadioButton rbtnMale;
    public RadioButton rbtnOther;
    public ListView friendList = new ListView<>();


    @FXML
    public void initialize() {
       btnCreateFriend.setDisable(true);
       btnDeleteFriend.setDisable(true);
       lblFiendName.setText("");
       lblFriendAge.setText("");
       lblFriendGender.setText("");
       rbtnMale.setSelected(true);
    }


    public String findGender(){
        String g = "heelo";
        if (rbtnFemale.isSelected()){
            g = "Female";
        }
        if (rbtnMale.isSelected()){
            g = "Male";
        }
        if (rbtnOther.isSelected()){
            g = "Other";
        }
        return g;
    }

    public void createFriend(ActionEvent actionEvent) {
        String n = txtfldFriendName.getText();
        int a = Integer.parseInt(txtfldFriendAge.getText());
        String g = "heelo";
        if (rbtnFemale.isSelected()){
            g = "Female";
        }
        if (rbtnMale.isSelected()){
            g = "Male";
        }
        if (rbtnOther.isSelected()){
            g = "Other";
        }
        Friend temp = new Friend(n, a, g);
        btnCreateFriend.setDisable(true);
        friendList.getItems().add(temp);
        txtfldFriendName.clear();
        txtfldFriendAge.clear();

    }

    public void displayInfo(MouseEvent mouseEvent) {
     Friend temp;
        temp = (Friend) friendList.getSelectionModel().getSelectedItem();
        btnDeleteFriend.setDisable(false);
        lblFiendName.setText(temp.name);
        lblFriendAge.setText(String.valueOf(temp.age));
        lblFriendGender.setText(temp.gender);
    }

    public void deleteFriend(ActionEvent actionEvent) {
    Friend subject;
        subject = (Friend) friendList.getSelectionModel().getSelectedItem();
        friendList.getItems().remove(subject);
        lblFiendName.setText("");
        lblFriendAge.setText("");
        lblFriendGender.setText("");
        btnDeleteFriend.setDisable(true);

    }

    private void updateCreateBtn(){
        boolean ageNotEmpty = !txtfldFriendAge.getText().isEmpty();
        boolean nameNotEmpty = !txtfldFriendName.getText().isEmpty();


        if (ageNotEmpty && nameNotEmpty){
            btnCreateFriend.setDisable(false);
        }
        else{
            btnCreateFriend.setDisable(true);
        }
    }

    public void textFieldChange(KeyEvent keyEvent) {
     updateCreateBtn();
    }

    public void keyTyped(KeyEvent keyEvent) {
        Friend temp;
        temp = (Friend) friendList.getSelectionModel().getSelectedItem();
        btnDeleteFriend.setDisable(false);
        lblFiendName.setText(temp.name);
        lblFriendAge.setText(String.valueOf(temp.age));
        lblFriendGender.setText(temp.gender);
    }
}
