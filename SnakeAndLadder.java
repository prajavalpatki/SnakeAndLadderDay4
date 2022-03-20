package com.Bridgelabz;

import java.util.Random;
import java.util.Scanner;

public class SnakeAndLadder {

    static Random random = new Random();
    int startPosition = 0;
    int currentPosition = 0;
    int position1 = 0;
    int position2 = 0;
    int playerDie = 0;
    int counterP1 = 0;
    int counterP2 = 0;
    int player = 1;

    public static void main(String[] args) {
        System.out.println("Welcome To Snake and Ladder Problem");

        SnakeAndLadder s1 = new SnakeAndLadder();
        System.out.println("Player 1 is Starting at: " + s1.startPosition);
        System.out.println("Player 2 is Starting at: " + s1.startPosition);

        while (s1.currentPosition != 100) {
            if (s1.player == 1) {
                s1.optionCheck(1);
            } else {
                s1.optionCheck(2);
            }
        }
    }

    static int getRandomDieValue() {
        int randomValue = random.nextInt(6) + 1;
        return randomValue;
    }

    static int getRandomOption() {
        int randomValue1 = random.nextInt(3);
        return randomValue1;
    }

    void checkPosition(int p) {

        if (currentPosition == 100) {
            System.out.println("Current Position of Player " + p + " is " + currentPosition);
            exitGame(p);
        } else if (currentPosition > 100) {
            currentPosition -= playerDie;
            System.out.println("Invalid move! You are at the same position.");
            System.out.println("Current Position of Player " + p + " is " + currentPosition);
        } else if (currentPosition < 0) {
            currentPosition = startPosition;
            System.out.println("Back to Start");
            System.out.println("Current Position of Player " + p + " is " + currentPosition);
        } else {
            System.out.println("Current Position of Player " + p + " is " + currentPosition);
        }
        position(p);
    }

    void position(int p) {
        if (p == 1) {
            position1 = currentPosition;
        } else {
            position2 = currentPosition;
        }
    }

    void optionCheck(int p) {
        if (p == 1) {
            counterP1++;
            currentPosition = position1;
        } else {
            counterP2++;
            currentPosition = position2;
        }
        playerDie = getRandomDieValue();
        System.out.println("Player " + p);
        System.out.println("Enter 5 to roll a die");
        Scanner in = new Scanner(System.in);
        int die = in.nextInt();
        if (die == 5) {
            System.out.println("Dice Face for Player " + p + ": " + playerDie);
            int option = getRandomOption();
            switch (option) {
                case 1:
                    System.out.println("Option: LADDER");
                    currentPosition += playerDie;
                    checkPosition(p);
                    optionCheck(p);
                    break;
                case 2:
                    System.out.println("Option: SNAKE");
                    currentPosition -= playerDie;
                    checkPosition(p);
                    checkPlayer();
                    break;
                default:
                    System.out.println("Option: No play");
                    checkPosition(p);
                    checkPlayer();
                    break;
            }
            position(p);
        } else {
            System.exit(0);
        }
    }

    void checkPlayer() {
        if (player == 1) {
            player = 2;
        } else {
            player = 1;
        }
    }

    void exitGame(int p) {
        int count = 0;
        if (p == 1) {
            count = counterP1;
        } else {
            count = counterP2;
        }
        System.out.println("Player " + p + " won the game!. It took " + count + " Dice plays to win.");
        System.exit(0);
    }
}