package com.Bridgelabz;

import java.util.Random;
import java.util.Scanner;

public class SnakeAndLadder {
    static Random random = new Random();
    static int getRandomDieValue() {
        int randomValue = random.nextInt(6) + 1;
        return randomValue;
    }
    public static void main(String[] args) {
        System.out.println("Welcome To Snake and Ladder Problem");

        Scanner in = new Scanner(System.in);
        int startPosition = 0;
        System.out.println("Game starts from : " + startPosition);
        System.out.println("Enter 1 to roll a die");
        int die = in.nextInt();
        if(die == 1){
            int playerDie = getRandomDieValue();
            System.out.println("Die Face: " +playerDie);
        }
        else {
            System.exit(0);
        }
    }
}
