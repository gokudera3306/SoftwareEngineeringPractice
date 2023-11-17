public class ScrollBar implements Widget {
    private final String name;
    private final String type;

    protected ScrollBar(String type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public void rendering() {
        System.out.println(type + " " + name);
    }
}
