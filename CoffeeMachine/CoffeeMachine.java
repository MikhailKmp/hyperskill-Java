import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        int water = 400;
        int milk = 540;
        int beans = 120;
        int cup = 9;
        int money = 550;

        System.out.println("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
                "Coffee is ready!\n");

        printState(water, milk, beans, cup, money);
        selectAction(water, milk, beans, cup, money);
    }

    public static void selectAction(int water, int milk, int beans, int cup, int money){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take):");
        String s = scanner.next();
        switch (s){
            case "buy":
                buy(water, milk, beans, cup, money);
                break;
            case "fill":
                fill(water, milk, beans, cup, money);
                break;
            case "take":
                take(water, milk, beans, cup, money);
                break;
        }
    }

    public static void buy(int water, int milk, int beans, int cup, int money){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int n = scanner.nextInt();
        switch (n){
            case 1:
                water -= 250;
                beans -= 16;
                money +=  4;
                cup -= 1;
                break;
            case 2:
                water -= 350;
                milk -= 75;
                beans -= 20;
                money += 7;
                cup -= 1;
                break;
            case 3:
                water -= 200;
                milk -= 100;
                beans -= 12;
                money += 6;
                cup -= 1;
                break;
        }
        printState(water, milk, beans, cup, money);
    }

    public static void fill(int water, int milk, int beans, int cup, int money){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water do you want to add:");
        water += scanner.nextInt();

        System.out.println("Write how many ml of milk do you want to add:");
        milk += scanner.nextInt();

        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans += scanner.nextInt();

        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cup += scanner.nextInt();

        printState(water, milk, beans, cup, money);
    }

    public static void take(int water, int milk, int beans, int cup, int money){
        System.out.println("I gave you $" + money);
        money = 0;
        printState(water, milk, beans, cup, money);
    }

    public static void printState(int water, int milk, int beans, int cup, int money){
        System.out.println("The coffee machine has:\n" +
                water + " of water\n" +
                milk + " of milk\n" +
                beans + " of coffee beans\n" +
                cup + " of disposable cups\n" +
                money + " of money");
    }
}