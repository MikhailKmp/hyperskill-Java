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

        if (!checkLength(scanner.nextInt())) {
            return;
        }

        generate();

        System.out.println("The random secret number is " + random + ".");

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
        if (bulls == 0 && cows == 0) {
            System.out.println("Grade: None. The secret code is " + random + ".");
        }
        else {
            System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s). The secret code is " + random + ".");
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