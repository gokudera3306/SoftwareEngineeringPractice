public class BoiledState implements BoilerState {
    private final ChocolateBoiler boiler;

    public BoiledState(ChocolateBoiler boiler) {
        this.boiler = boiler;
    }

    @Override
    public void fill() {
//        System.out.println("Already filled");
    }

    @Override
    public void boil() {
//        System.out.println("Already boiled");
    }

    @Override
    public void drain() {
        System.out.println("Drain the boiled chocolate");
        boiler.setState(new EmptyState(boiler));
    }
}
