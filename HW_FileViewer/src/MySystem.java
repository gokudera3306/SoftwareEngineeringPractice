import java.util.HashMap;
import java.util.Map;

public class MySystem {
    private final Map<String, IView> viewMap = new HashMap<>();

    public void addTextView(String name, String text) {
        var newTextView = new TextView(name, text);

        viewMap.put(name, newTextView);
    }

    public void addElement(String name, String element) throws Exception {
        var view = viewMap.get(name);

        var newView = switch (element) {
            case "scrollBar" -> new ScrollBarDecorator(view);
            case "thickBlackBorder" -> new ThickBlackBorderDecorator(view);
            default -> throw new Exception("");
        };

        viewMap.put(name, newView);
    }

    public void display(String name) {
        var view = viewMap.get(name);
        view.display();
        System.out.println();
    }
}
