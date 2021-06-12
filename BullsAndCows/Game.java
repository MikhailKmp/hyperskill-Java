import java.util.Random;
import java.util.Scanner;

public class Game {
    private int bulls;
    private int cows;
    private int length;
    private long random;
    private long answer;

    public void setAnswer(long answer) {
        this.answer = answer;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, enter the secret code's length:");
        if (!checkLength(scanner.nextInt())) {
            return;
        }
        System.out.println("Okay, let's start a game!");

        generate();

        int i = 1;
        while (bulls != length) {
            System.out.println("Turn " + i + ":");
            setAnswer(scanner.nextLong());
            calculateBullsAndCows();
            printResult();
            i++;
        }

        scanner.close();
    }

    private void generate() {
        Random random = new Random();

        long mult = (long) Math.pow(10, length - 1);
        int[] arr = new int[length];
        long result = 0;
        boolean zero = false;
        int n;

        for (int i = 0; i < length; i++) {
            do {
                n = random.nextInt(10);
                if (!zero && n == 0 && i != 0){
                    zero = true;
                    break;
                }
            } while (repeatCheck(arr, n));

            if (n != 0)
                result += n * mult;

            arr[i] = n;
            mult /= 10;
        }
        this.random = result;
    }

    private boolean repeatCheck(int[] arr, int random) {
        for (int temp : arr) {
            if (temp == random){
                return true;
            }
        }
        return false;
    }

    private void calculateBullsAndCows() {
        bulls = 0;
        cows = 0;
        int[] arrAnswer = convertNumberToArray(answer);
        int[] arrRandom = convertNumberToArray(random);

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (arrAnswer[i] == arrRandom[j] && i == j) {
                    bulls++;
                }
                else if (arrAnswer[i] == arrRandom[j] && i != j)
                    cows++;
            }
        }
    }

    private int[] convertNumberToArray(long number) {
        int[] arr = new int[length];
        for (int i = arr.length - 1; i >= 0 ; i--) {
            arr[i] = (int) (number % 10);
            number /= 10;
        }
        return arr;
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

    private boolean checkLength(int length) {
        if (length > 10) {
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
            return false;
        }
        setLength(length);
        return true;
    }
}