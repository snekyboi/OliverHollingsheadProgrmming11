package com.company.ollie;


import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<String> lines = new ArrayList();
        String[] testWords = {"Computer","program","the", "alligator"};


        FileReader fr = new FileReader("in.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null){
            lines.add(line);
        }
        br.close();


        for (String testWord : testWords){
            ArrayList<Integer> result = wordChecker(testWord, lines);
            System.out.print("i found " + testWord + " on lines:");
            System.out.println(result);
        }

    }

    public static ArrayList<Integer> wordChecker(String input, ArrayList<String> lines){
        ArrayList<Integer> result = new ArrayList<Integer>();
        int lineNumber = 0;
        for (String line: lines){
            if (line.toLowerCase().contains(input.toLowerCase())){
                result.add(lineNumber);
            }
            lineNumber ++;
        }
        return result;
    }
}
