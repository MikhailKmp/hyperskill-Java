import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Write how many cups of cofee you will need:");
        int n = scanner.nextInt();
        CoffeeMachine.countCoffee(n);

    }
    
    public static void countCoffee(int n){
        System.out.println("For " + n + " cups of coffee you will need:\n" 
                            + 200 * n + " ml of water\n"
                            + 50 * n + " ml of milk\n"
                            + 15 * n + " g of coffee beans");
    }
}