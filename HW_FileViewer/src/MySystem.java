import java.util.HashMap;
import java.util.Map;

public class MySystem {
    private final Map<String, ITextView> textViewMap = new HashMap<>();

    public void addTextView(String name, String text) {
        var newTextView = new TextView(name, text);

        textViewMap.put(name, newTextView);
    }

    public void addElement(String name, String element) throws Exception {
        var textView = textViewMap.get(name);

        var newTextView = switch (element) {
            case "scrollBar" -> new ScrollBarDecorator(textView);
            case "thickBlackBorder" -> new ThickBlackBorderDecorator(textView);
            default -> throw new Exception("");
        };

        textViewMap.put(name, newTextView);
    }

    public void display(String name) {
        var textView = textViewMap.get(name);
        textView.display();
        System.out.println();
    }
}
