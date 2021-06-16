package machine;

import java.util.Scanner;

public class CoffeeMachine {
    State state;
    int water;
    int milk;
    int beans;
    int cup;
    int money;
    boolean work;

    public CoffeeMachine() {
        state = new ChoosingAction(this);
        water = 400;
        milk = 540;
        beans = 120;
        cup = 9;
        money = 550;
        work = true;
    }

    public void changeState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void buy(String s) {
        switch (s){
            case "1":
                if(checkAmountOfCoffee(250, 1, 16, 1)) {
                    water -= 250;
                    beans -= 16;
                    money +=  4;
                    cup -= 1;
                }
                break;
            case "2":
                if(checkAmountOfCoffee(350, 75, 20, 1)) {
                    water -= 350;
                    milk -= 75;
                    beans -= 20;
                    money += 7;
                    cup -= 1;
                }
                break;
            case "3":
                if(checkAmountOfCoffee(200, 100, 12, 1)) {
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

    public void fill() {
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

    public void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public void remaining() {
        System.out.println("The coffee machine has:\n" +
                water + " of water\n" +
                milk + " of milk\n" +
                beans + " of coffee beans\n" +
                cup + " of disposable cups\n" +
                money + " of money");
    }

    public boolean checkAmountOfCoffee(int water, int milk, int beans, int n) {
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

    public void printChoose() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }
}