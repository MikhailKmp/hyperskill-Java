import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        coffeeMachine.printChoose();

        do{
            coffeeMachine.getState().selectAction(scanner.next());
        } while (coffeeMachine.work);
    }
}
