import java.util.List;

public class SimpleStrategy implements IBreakStrategy {
    @Override
    public void Display(List<Component> component) {
        for (var c : component) System.out.println(c);
    }
}
