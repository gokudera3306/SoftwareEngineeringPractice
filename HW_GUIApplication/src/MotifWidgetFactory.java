public class MotifWidgetFactory implements WidgetFactory {
    @Override
    public Window CreateWindow(String name) {
        return new MotifWindow(name);
    }

    @Override
    public ScrollBar CreateScrollBar(String name) {
        return new MotifScrollBar(name);
    }

    @Override
    public Button CreateButton(String name) {
        return new MotifButton(name);
    }
}
