package com.Bridgelabz;

import java.util.Random;
import java.util.Scanner;

public class SnakeAndLadder {
    static Random random = new Random();

    static int getRandomDieValue() {
        int randomValue = random.nextInt(6) + 1;
        return randomValue;
    }

    static int getRandomOption() {
        int randomValue1 = random.nextInt(3);
        return randomValue1;
    }

    public static void main(String[] args) {
        System.out.println("Welcome To Snake and Ladder Problem");

        Scanner in = new Scanner(System.in);
        int startPosition = 0;
        int currentPosition = 0;
        System.out.println("Game starts from : " + startPosition);
        while (currentPosition != 100) {
            System.out.println("Enter 1 to roll a die");
            int die = in.nextInt();
            if (die == 1) {
                int playerDie = getRandomDieValue();
                System.out.println("Die Face: " + playerDie);
                int option = getRandomOption();
                switch (option) {
                    case 1:
                        System.out.println("Option: LADDER");
                        currentPosition += playerDie;
                        break;
                    case 2:
                        System.out.println("Option: SNAKE");
                        currentPosition -= playerDie;
                        break;
                    default:
                        System.out.println("Option: NO PLAY");
                        break;
                }
                if (currentPosition == 100) {
                    System.out.println("Position: " + currentPosition);
                    System.out.println("You Won!");
                    break;
                } else if (currentPosition > 100) {
                    currentPosition -= playerDie;
                    System.out.println("Invalid move! You are at the same position.");
                    System.out.println("Current Position: " + currentPosition);
                }
                else if (currentPosition < 0) {
                    currentPosition = startPosition;
                    System.out.println("Back to Start");
                    System.out.println("Current Position: " + currentPosition);
                } else {
                    System.out.println("Current Position: " + currentPosition);
                }
            }
            else{
                System.exit(0);
            }
        }
    }
}
