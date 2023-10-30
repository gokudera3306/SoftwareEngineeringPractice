public abstract class Component {
    private int id;
    private int size;
    private int shrinkability;
    private int stretchability;
    private String content;

    protected Component(int id, int size, int shrinkability, int stretchability, String content) {
        this.id = id;

        this.size = size;
        this.shrinkability = shrinkability;
        this.stretchability = stretchability;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void ChangeSize(int newSize) {
        if (newSize < shrinkability || stretchability < newSize) {
            System.out.printf("component %d failed to change size%n", id);
        } else {
            size = newSize;
            System.out.printf("component %d size changed to %d%n", id, newSize);
        }
    }

    @Override
    public String toString() {
        return String.format("[%d]%s", size, content);
    }
}
