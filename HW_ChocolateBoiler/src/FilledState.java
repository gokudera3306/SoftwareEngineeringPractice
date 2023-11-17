public class FilledState implements BoilerState {
    private final ChocolateBoiler boiler;

    public FilledState(ChocolateBoiler boiler) {
        this.boiler = boiler;
    }

    @Override
    public void fill() {
//        System.out.println("Already filled");
    }

    @Override
    public void boil() {
        System.out.println("Boil chocolate");
        boiler.setState(new BoiledState(boiler));
    }

    @Override
    public void drain() {
//        System.out.println("Not boiled");
    }
}
