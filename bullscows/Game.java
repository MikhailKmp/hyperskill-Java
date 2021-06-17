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
        if (!setLength(scanner.nextLine())) {
            return;
        }

        System.out.println("Input the number of possible symbols in the code:");
        if (!setCharacterRange(scanner.nextLine())) {
            return;
        }

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

    private boolean setLength(String string) {
        if (!numberInputValidation(string)){
            return false;
        }
        length = Integer.parseInt(string);

        if (length == 0) {
            System.out.println("Error: length cannot be 0.");
            return false;
        }
        else if (length > 36) {
            System.out.println("Error: maximum code length is 36 (0-9, a-z).");
            return false;
        }
        return true;
    }

    private boolean setCharacterRange(String string) {
        if (!numberInputValidation(string)){
            return false;
        }
        characterRange = Integer.parseInt(string);

        if (characterRange > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            return false;
        }
        else if (characterRange < length) {
            System.out.println("Error: it's not possible to generate a code with a length of " +
                    length +
                    " with " +
                    characterRange +
                    " unique symbols.");
            return false;
        }
        return true;
    }

    private boolean numberInputValidation(String input) {
        try {
            int number = Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            System.out.println("Error: \"" + input + "\" isn't a valid number.");
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