import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the game, Guess the number");
        System.out.print("What is your name?: ");
        String name = sc.nextLine();
        System.out.print("Hello " + name + ". Do you want to start the game?(y/n): ");
        String response = sc.nextLine();

        while (!response.equals("y")) {
            System.out.print("Hello " + name + ". Do you want to start the game?(y/n): ");
            response = sc.nextLine();
        }

        Random rand = new Random();
        int randInt = rand.nextInt(20) + 1;
        System.out.print("Please guess a number from 1 to 20: ");
        int guess = sc.nextInt();

        int timesTried = 0;
        boolean hasWon = false;
        boolean shouldFinish = false;

        while (!shouldFinish) {
            timesTried++;

            if (timesTried < 5) {
                if (guess == randInt) {
                    hasWon = true;
                    shouldFinish = true;
                } else if (guess > randInt) {
                    System.out.print("Try lower: ");
                    guess = sc.nextInt();
                } else {
                    System.out.print("Try higher: ");
                    guess = sc.nextInt();
                }
            } else {
                shouldFinish = true;
            }
        }

        if (hasWon) {
            System.out.println("Congratulations! You have successfully guessed the number in " + timesTried + " times");
        } else {
            System.out.println("Game Over!");
            System.out.println("The number was " + randInt);
        }
    }
}
