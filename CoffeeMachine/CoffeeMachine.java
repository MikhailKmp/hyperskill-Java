import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
                "Coffee is ready!\n");
        
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();
        
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();
        
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffee = scanner.nextInt();
    
        System.out.println("Write how many cups of cofee you will need:");
        int n = scanner.nextInt();
        CoffeeMachine.checkAmountOfCoffee(water, milk, coffee, n);

    }
    
    public static void checkAmountOfCoffee(int water, int milk, int coffee, int n){
        int w = water / 200;
        int m = milk / 50;
        int g = coffee / 15;
        
        int answer = 0;
        
        if (w < m) {
            answer = w;
        }
        else {
            answer = m; 
        }
        
        if (g < answer) {
            answer = g;
        }
        
        if (answer == n) {
            System.out.println("Yes, I can make that amount of coffee");
        }
        
        else if (answer > n) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (answer - n) + " more than that");
        }
        
        else {
            System.out.println("No, I can make only " + answer + " cup(s) of coffee");
        }
    }
}