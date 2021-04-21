package sample;

import javafx.event.ActionEvent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Friend {
    public String name;
    public int age;
    public String gender;


    Friend (String n, int a, String g){
        name = n;
        age = a;
        gender = g;
    }

    public Friend(String text, int parseInt) {
    }

    public void writeToFile(BufferedWriter bw) throws IOException {
        // this function helps saveFriend write in friends.txt
        bw.write(name + "\r");
        bw.write(gender + "\r");
        bw.write(Integer.toString(age) + "\r");
        bw.write(";\r");

    }

    public String toString(){
        return name;
    }
}
