public class ChocolateBoiler {
    private static ChocolateBoiler instance;
    private BoilerState state;

    private ChocolateBoiler() {
        state = new EmptyState(this);
    }

    public static ChocolateBoiler getInstance() {
        if (instance == null)
            instance = new ChocolateBoiler();

        return instance;
    }

    public void setState(BoilerState state) {
        this.state = state;
    }

    public void boil() {
        state.boil();
    }

    public void fill() {
        state.fill();
    }

    public void drain() {
        state.drain();
    }
}
