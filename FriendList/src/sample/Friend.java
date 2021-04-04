package sample;

import javafx.event.ActionEvent;

public class Friend {
    public String name;
    public int age;
    public String gender;


    Friend (String n, int a, String g){
        name = n;
        age = a;
        gender = g;
    }

    public String toString(){
        return name;
    }
}
