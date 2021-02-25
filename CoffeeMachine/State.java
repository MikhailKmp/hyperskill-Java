public abstract class State {
    public CoffeeMachine coffeeMachine;

    public State(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    public abstract void selectAction(String string);
}
