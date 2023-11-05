public abstract class Document {
    protected String type;

    protected Document(String type) {
        this.type = type;
    }

    public void present() {
        System.out.println(type);
    }
}
