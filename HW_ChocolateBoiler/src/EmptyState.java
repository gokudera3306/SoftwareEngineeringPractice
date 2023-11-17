public class EmptyState implements BoilerState {
    private final ChocolateBoiler boiler;

    public EmptyState(ChocolateBoiler boiler) {
        this.boiler = boiler;
    }

    @Override
    public void fill() {
        System.out.println("Fill chocolate");
        boiler.setState(new FilledState(boiler));
    }

    @Override
    public void boil() {
//        System.out.println("Nothing inside");
    }

    @Override
    public void drain() {
//        System.out.println("Nothing inside");
    }
}
