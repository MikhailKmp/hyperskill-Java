public class ChoosingAction extends State {

    public ChoosingAction(CoffeeMachine coffeeMachine) {
        super(coffeeMachine);
    }

    @Override
    public void selectAction(String string) {
        switch (string) {
            case "buy":
                coffeeMachine.changeState(new ChoosingCoffee(coffeeMachine));
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                break;
            case "fill":
                coffeeMachine.fill();
                coffeeMachine.printChoose();
                break;
            case "take":
                coffeeMachine.take();
                coffeeMachine.printChoose();
                break;
            case "remaining":
                coffeeMachine.remaining();
                coffeeMachine.printChoose();
                break;
            case "exit":
                coffeeMachine.work = false;
                break;
        }
    }
}