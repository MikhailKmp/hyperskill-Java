import java.util.Random;
import java.util.Scanner;

public class Game {
    private int bulls;
    private int cows;
    private int length;
    private int random;
    private int answer;

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        setLength(4);
        generate();

        setAnswer(scanner.nextInt());

        calculateBullsAndCows();
        printResult();

        scanner.close();
    }

    private void generate() {
        Random random = new Random();

        int[] arr = new int[length];
        int result = 0;
        int mult = 1;
        int n;

        for (int i = 0; i < length; i++) {
            do {
                n = random.nextInt(10);
            } while (repeatCheck(arr, n));
            result += n * mult;
            mult *= 10;
            arr[i] = n;
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

    private int[] convertNumberToArray(int number) {
        int[] arr = new int[length];
        for (int i = arr.length - 1; i >= 0 ; i--) {
            arr[i] = number % 10;
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
}