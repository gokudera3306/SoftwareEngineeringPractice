import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class GUIApplication {
    private final LinkedList<WidgetInfo> widgetInfos = new LinkedList<>();
    private WidgetFactory factory = new MotifWidgetFactory();

    public void addWidget(String type, String name) {
        widgetInfos.add(new WidgetInfo(type, name));
    }

    public void switchStyle(String style) throws Exception {
        factory = switch (style) {
            case "Motif" -> new MotifWidgetFactory();
            case "PM" -> new PresentationManagerWidgetFactory();
            default -> throw new Exception();
        };
    }

    public void present() {

        var tempList = (List<WidgetInfo>)widgetInfos.clone();
        tempList.sort(Comparator.comparingInt(widget -> WidgetType.getOrder(widget.type)));

        for (var widgetInfo : tempList) {
            var widget = switch (widgetInfo.type) {
                case Window -> factory.CreateWindow(widgetInfo.name);
                case ScrollBar -> factory.CreateScrollBar(widgetInfo.name);
                case Button -> factory.CreateButton(widgetInfo.name);
            };
            widget.rendering();
        }
    }

    private static class WidgetInfo {
        public WidgetType type;
        public String name;

        public WidgetInfo(String type, String name) {
            this.type = WidgetType.valueOf(type);
            this.name = name;
        }
    }
}
