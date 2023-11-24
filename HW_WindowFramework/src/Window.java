public abstract class Window {
    private final WindowImplementation implementation;

    public Window(WindowImplementation implementation) {
        this.implementation = implementation;
    }

    public void drawBorder() {
        implementation.drawText();
        implementation.drawRect();
    }

    public void drawCloseBox() {
        implementation.drawRect();
    }
}
