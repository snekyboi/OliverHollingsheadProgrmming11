package sample;

import sample.Friend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreateFriend {
    private static String name;
    private static String gender;
    private static int age;
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Friend> friends = new ArrayList<>();

    public static ArrayList createAllFriends (String fileName) throws IOException {
        // this function separates all the friends in friends.txt
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        String line;
        String friendString = "";
        while ((line = br.readLine()) !=null){
            if (!line.equals(";")){
                friendString += line + ",";
            }else{
                parseFriend(friendString);
                friendString = "";
            }
        }
        return friends;
    }
    private static void parseFriend(String string){
        // this function separates the three parts of a friend (name, age and gender)
        int pos = 0;
        String name = "";
        int age = 0;
        String gender = "";
        for (int i = 0; i < string.length(); i++){
            if (string.substring(i, i+1).equals(",")){
                pos = i;
                name = string.substring(0, pos);
                gender = string.substring(pos+1, pos +2);
                String ageTo = string.substring(pos+3);
                age = Integer.parseInt(String.valueOf(pos+3));
                break;
            }
        }
        friends.add(new Friend(name, age, gender));
    }
}
