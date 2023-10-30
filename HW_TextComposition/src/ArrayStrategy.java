import java.util.List;

public class ArrayStrategy implements IBreakStrategy {
    @Override
    public void Display(List<Component> component) {
        var line = new StringBuilder();
        for (var i = 0; i < component.size(); i++){
            line.append(" ").append(component.get(i));

            if (i != 0 && (i + 1) % 3 == 0) {
                var lineString = line.toString().trim();
                System.out.println(lineString);
                line = new StringBuilder();
            }
        }

        if (!line.isEmpty())
            System.out.println(line.toString().trim());
    }
}
