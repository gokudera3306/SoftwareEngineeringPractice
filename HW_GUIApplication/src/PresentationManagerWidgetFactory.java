public class PresentationManagerWidgetFactory implements WidgetFactory {
    @Override
    public Window CreateWindow(String name) {
        return new PresentationManagerWindow(name);
    }

    @Override
    public ScrollBar CreateScrollBar(String name) {
        return new PresentationManagerScrollBar(name);
    }

    @Override
    public Button CreateButton(String name) {
        return new PresentationManagerButton(name);
    }
}
