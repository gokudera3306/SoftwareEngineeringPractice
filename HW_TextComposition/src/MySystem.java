import java.util.LinkedList;
import java.util.List;

public class MySystem {
    private final List<Component> componentList = new LinkedList<>();

    public void AddComponent(String type, int id, int size, int shrinkSize, int stretchSize, String content) throws Exception {
        var newComp = switch (type) {
            case "Text" -> new Text(id, size, shrinkSize, stretchSize, content);
            case "GraphicalElement" -> new GraphicalElement(id, size, shrinkSize, stretchSize, content);
            default -> throw new Exception("Not Supported.");
        };

        componentList.add(newComp);
    }

    public void ChangeSize(int componentId, int newSize) {
        for (var c : componentList) {
            if (c.getId() != componentId) continue;

            c.ChangeSize(newSize);
            break;
        }
    }

    public void Display(String strategyName) throws Exception {
        var strategy = BreakStrategyFactory.CreateStrategy(strategyName);

        strategy.Display(componentList);
    }

    private static class BreakStrategyFactory {
        public static IBreakStrategy CreateStrategy(String strategyName) throws Exception {
            return switch (strategyName) {
                case "SimpleComposition" -> new SimpleStrategy();
                case "TexComposition" -> new TexStrategy();
                case "ArrayComposition" -> new ArrayStrategy();
                default -> throw new Exception();
            };
        }
    }
}
