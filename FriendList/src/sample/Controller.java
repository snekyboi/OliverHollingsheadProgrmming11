package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ListView;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

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
    public Button btnSaveFriend;
    public Button btnLoadFriend;


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
            g = "F";
        }
        if (rbtnMale.isSelected()){
            g = "M";
        }
        if (rbtnOther.isSelected()){
            g = "O";
        }
        return g;
    }

    public void createFriend(ActionEvent actionEvent) {
        friendList.getItems().add(new Friend(txtfldFriendName.getText(), Integer.parseInt(txtfldFriendAge.getText()), findGender()));
        txtfldFriendName.clear();
        txtfldFriendAge.clear();
        rbtnMale.setSelected(true);
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

    public void saveFriend(ActionEvent actionEvent) throws IOException {
        // this function writes friends to friends.txt
        ObservableList<Friend> myList = friendList.getItems();
        FileWriter fw = new FileWriter("friends.txt", false);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Friend f : myList){
            f.writeToFile(bw);
        }
        bw.close();
    }

    public void loadFriends(ActionEvent actionEvent) throws IOException {
        // To stop the user from having the ability to load multiple versions of the same friend
        // I disabled the load button whenever you load because you should really only have to load
        //the list once.
        ArrayList<Friend> friends = CreateFriend.createAllFriends("friends.txt");
        for (Friend f : friends){
            friendList.getItems().add(f);
        }
        btnLoadFriend.setDisable(true);
    }
}
