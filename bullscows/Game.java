package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private int bulls;
    private int cows;
    private int length;
    private String random;
    private String answer;
    private int characterRange;

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the length of the secret code:");
        do {
            length = Integer.parseInt(scanner.nextLine());
        } while (!checkLength());

        System.out.println("Input the number of possible symbols in the code:");
        do {
            characterRange = Integer.parseInt(scanner.nextLine());
        } while (!checkCharacterRange());

        printInfo();

        System.out.println("Okay, let's start a game!");

        generate();

        int i = 1;
        while (bulls != length) {
            System.out.println("Turn " + i + ":");
            answer = scanner.nextLine();
            calculateBullsAndCows();
            printResult();
            i++;
        }
        scanner.close();
    }

    private void generate() {
        Random random = new Random();
        StringBuilder result = new StringBuilder();

        while (result.length() != length) {
            int n = random.nextInt(characterRange);
            if (n < 10 && !result.toString().contains(Character.toString(48 + n)))
                result.append(Character.toString(48 + n));
            else if (n >= 10 && !result.toString().contains(Character.toString(97 + n - 10)))
                result.append(Character.toString(97 + n - 10));
        }
        this.random = result.toString();
    }


    private void calculateBullsAndCows() {
        bulls = 0;
        cows = 0;
        char charAnswer;
        char charRandom;

        for (int i = 0; i < length; i++) {
            charAnswer = answer.charAt(i);
            for (int j = 0; j < length; j++) {
                charRandom = random.charAt(j);
                if (charAnswer == charRandom && i == j) {
                    bulls++;
                }
                else if (charAnswer == charRandom && i != j)
                    cows++;
            }
        }
    }

    private void printResult() {
        String bull = "bull";
        String cow = "cow";

        if (bulls > 1)
            bull = "bulls";
        if (cows > 1)
            cow = "cows";

        if (bulls == length) {
            System.out.println("Grade: " + bulls + " " + bull + "\n" +
                    "Congratulations! You guessed the secret code.");
        }
        else if (bulls == 0 && cows == 0) {
            System.out.println("Grade: None.");
        }
        else {
            System.out.println("Grade: " + bulls + " " + bull + " and " + cows + " " + cow);
        }
    }

    private boolean checkLength() {
        if (length > 36) {
            System.out.println("Error: can't generate a secret number with a length of " + length + " because there aren't enough unique characters. Re-enter.");
            return false;
        }
        return true;
    }

    private boolean checkCharacterRange() {
        if (characterRange < length) {
            System.out.println("The range cannot be less than the length. Re-enter.");
            return false;
        }
        return true;
    }

    private void printInfo() {
        System.out.print("The secret is prepared: ");
        for (int i = 0; i < length; i++) {
            System.out.print("*");
        }
        System.out.println(" ");
        if (characterRange <= 10) {
            System.out.println("(" + (char) 48 + "-" + (char) (48 + characterRange - 1) + ")");
        }
        else {
            System.out.println("(0-9, " + (char) 97 + "-" + (char) (97 + characterRange - 10 - 1) + ")");
        }
    }
}