import java.util.LinkedList;
import java.util.List;

public class LargerComponent implements Component {
    private final List<Component> components = new LinkedList<>();

    public void addComponent(Component component) {
        components.add(component);
    }

    @Override
    public void draw() {
        System.out.print("Group:{");

        for (Component component : components) {
            component.draw();
            System.out.print(" ");
        }

        System.out.print("}");
    }
}
