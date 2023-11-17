import java.util.Arrays;
import java.util.List;

public enum WidgetType {
    Window,
    ScrollBar,
    Button;

    private static final List<WidgetType> order = Arrays.asList(Window, ScrollBar, Button);

    public static int getOrder(WidgetType type) {
        return order.indexOf(type);
    }
}
