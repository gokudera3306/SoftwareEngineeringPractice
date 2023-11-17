public interface WidgetFactory {
    Window CreateWindow(String name);
    ScrollBar CreateScrollBar(String name);
    Button CreateButton(String name);
}
