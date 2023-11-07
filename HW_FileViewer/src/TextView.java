public class TextView implements IView {
    private final String name;
    private final String text;

    public TextView(String name, String text) {
        this.name = name;
        this.text = text;
    }

    @Override
    public void display() {
        System.out.print(text);
    }
}
