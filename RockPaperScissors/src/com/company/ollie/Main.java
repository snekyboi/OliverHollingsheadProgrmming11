package com.company.ollie;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //these are used later on in the program
        String computerMovePrintout = "";
        String userInputPrintout = "";

        // This block takes the user input and stores it.
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose rock paper or scissors. 'r' for rock, 'p' for paper and 's' for scissors");
        String userInput = scan.next();

        // this block determines the computer's random move by picking a number between 0 and 2
        // if it gets 0 computerMove is r
        // if it gets 1 computerMove is p
        // if it gets 2 computerMove is s

        String computerMove = "";

        int random = (int)(Math.random()*3);
        if (random == 0) {
            computerMove = "r";
        }
        else if (random == 1) {
            computerMove = "p";
        }
        else if (random == 2) {
            computerMove = "s";
        }

        // this block determines if the user loses
        if ((computerMove.equals("p")) && (userInput.equals("r"))){
         System.out.println("You Lose!");
        }
        else if ((computerMove.equals("r")) && (userInput.equals("s"))) {
            System.out.println("You Lose!");
        }
        else if ((computerMove.equals("s")) && (userInput.equals("p"))) {
            System.out.println("You Lose!");
        }

        // this block determines if the user and computer tie
        else if ((computerMove.equals("p")) && (userInput.equals("p"))) {
            System.out.println("Draw!");
        }
        else if ((computerMove.equals("r")) && (userInput.equals("r"))) {
            System.out.println("Draw!");
        }
        else if ((computerMove.equals("s")) && (userInput.equals("s"))) {
            System.out.println("Draw!");
        }

        // this block determines if the user wins
        else if ((computerMove.equals("p")) && (userInput.equals("s"))) {
            System.out.println("You Win!");
        }
        else if ((computerMove.equals("r")) && (userInput.equals("p"))) {
            System.out.println("You Win!");
        }
        else if ((computerMove.equals("s")) && (userInput.equals("r"))) {
            System.out.println("You Win!");
        }
        // this block turns the computer's single letter input into a word. r is rock p into paper
        // and s into scissors.
        if (computerMove.equals("r")) {
            computerMovePrintout = "rock";
        }
        else if (computerMove.equals("p")){
            computerMovePrintout = "paper";
        }
        else if (computerMove.equals("s")){
            computerMovePrintout = "scissors";
        }
        // this block turns the user's single letter input into a word. r is rock p into paper
        // and s into scissors.
        if (userInput.equals("r")) {
            userInputPrintout = "rock";
        }
        else if (userInput.equals("p")){
            userInputPrintout = "paper";
        }
        else if (userInput.equals("s")){
            userInputPrintout = "scissors";
        }
        //this block handles a selection from the user that is not valid
        if (!userInput.equals("r") && !userInput.equals("p") && !userInput.equals("s")){
            System.out.println("Invalid selection please play again.");
        }
        // this block prints what both sides picked
        else {
            System.out.println("Computer Choice: " + computerMovePrintout + " User Choice: " + userInputPrintout);
        }

    }
}
