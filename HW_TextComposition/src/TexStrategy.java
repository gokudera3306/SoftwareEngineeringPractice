import java.util.List;

public class TexStrategy implements IBreakStrategy {
    @Override
    public void Display(List<Component> component) {
        var line = new StringBuilder();
        for (var c : component) {
            var content = c.getContent();
            line.append(" ").append(c);

            if (content.equals("<ParagraphEnd>")) {
                var lineString = line.toString().trim();
                System.out.println(lineString);
                line = new StringBuilder();
            }
        }

        if (!line.isEmpty())
            System.out.println(line.toString().trim());
    }
}
