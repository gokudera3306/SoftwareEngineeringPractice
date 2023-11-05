import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        var system = new MySystem();

        try {
//            var reader = new BufferedReader(new FileReader(args[0]));
            var reader = new BufferedReader(new FileReader("HW_FileViewer/src/sampleInput"));

            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                var tokens = line.split(" ");
                if (tokens.length >= 2) {
                    var viewName = tokens[0];
                    var command = tokens[1];
                    switch (command) {
                        case "add":
                            if (tokens.length >= 3) {
                                for (var element : Arrays.stream(tokens).skip(2).toList()) {
                                    system.addElement(viewName, element);
                                }
                            } else {
                                throw new Exception("Invalid add command.");
                            }
                            break;
                        case "display":
                            if (tokens.length == 2) {
                                system.display(viewName);
                            } else {
                                throw new Exception("Invalid display command.");
                            }
                            break;
                        default:
                            if (tokens.length == 2) {
                                var text = tokens[1];
                                system.addTextView(viewName, text);
                            } else {
                                throw new Exception("Invalid view command.");
                            }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid Input.");
        }
    }
}
