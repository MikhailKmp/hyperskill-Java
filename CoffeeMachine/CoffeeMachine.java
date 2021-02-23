import java.util.Scanner;

public class CoffeeMachine {
    int water = 400;
    int milk = 540;
    int beans = 120;
    int cup = 9;
    int money = 550;

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Boolean work;

        do{
            work = coffeeMachine.selectAction();
        } while (work);

    }

    public boolean selectAction(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String s = scanner.next();
        switch (s){
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
            case "remaining":
                remaining();
                break;
            case "exit":
                return false;
        }
        return true;
    }

    public void buy(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String n = scanner.next();
        switch (n){
            case "1":
                if(checkAmountOfCoffee(250, 1, 16, 1)){
                    water -= 250;
                    beans -= 16;
                    money +=  4;
                    cup -= 1;
                }
                break;
            case "2":
                if(checkAmountOfCoffee(350, 75, 20, 1)){
                    water -= 350;
                    milk -= 75;
                    beans -= 20;
                    money += 7;
                    cup -= 1;
                }
                break;
            case "3":
                if(checkAmountOfCoffee(200, 100, 12, 1)){
                    water -= 200;
                    milk -= 100;
                    beans -= 12;
                    money += 6;
                    cup -= 1;
                }
                break;
            case "back":
                break;
        }
    }

    public void fill(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water do you want to add:");
        water += scanner.nextInt();

        System.out.println("Write how many ml of milk do you want to add:");
        milk += scanner.nextInt();

        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans += scanner.nextInt();

        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cup += scanner.nextInt();

    }

    public void take(){
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public void remaining(){
        System.out.println("The coffee machine has:\n" +
                water + " of water\n" +
                milk + " of milk\n" +
                beans + " of coffee beans\n" +
                cup + " of disposable cups\n" +
                money + " of money");
    }

    public boolean checkAmountOfCoffee(int water, int milk, int beans, int n){
        int w = this.water / water;
        int m = this.milk / milk;
        int g = this.beans / beans;

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

        if (answer == n || answer > n) {
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        }

        else {
            System.out.println("No, I can make only " + answer + " cup(s) of coffee");
            return false;
        }
    }
}