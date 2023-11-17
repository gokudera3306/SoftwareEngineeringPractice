public class Window implements Widget {
    private final String name;
    private final String type;

    protected Window(String type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public void rendering() {
        System.out.println(type + " " + name);
    }
}
