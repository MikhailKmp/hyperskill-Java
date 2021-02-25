public class ChoosingCoffee extends State {

    public ChoosingCoffee(CoffeeMachine coffeeMachine) {
        super(coffeeMachine);
    }

    @Override
    public void selectAction(String string) {
        coffeeMachine.buy(string);
        coffeeMachine.changeState(new ChoosingAction(coffeeMachine));
        coffeeMachine.printChoose();
    }
}
