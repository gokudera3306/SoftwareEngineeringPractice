import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var system = new MySystem();

        try {
            var reader = new BufferedReader(new FileReader(args[0]));
//            var reader = new BufferedReader(new FileReader("src/sampleInput"));

            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                var tokens = line.split(" ");
                if (tokens.length > 0) {
                    var command = tokens[0];
                    switch (command) {
                        case "Text":
                        case "GraphicalElement":
                            if (tokens.length == 6) {
                                var type = tokens[0];
                                var componentID = Integer.parseInt(tokens[1]);
                                var naturalSize = Integer.parseInt(tokens[2]);
                                var shrinkability = Integer.parseInt(tokens[3]);
                                var stretchability = Integer.parseInt(tokens[4]);
                                var content = tokens[5];

                                system.AddComponent(type, componentID, naturalSize, shrinkability, stretchability, content);
                            } else {
                                System.out.println("Invalid " + command + " command.");
                            }
                            break;
                        case "ChangeSize":
                            if (tokens.length == 3) {
                                var componentID = Integer.parseInt(tokens[1]);
                                var newSize = Integer.parseInt(tokens[2]);

                                system.ChangeSize(componentID, newSize);
                            } else {
                                System.out.println("Invalid ChangeSize command.");
                            }
                            break;
                        case "Require":
                            if (tokens.length == 2) {
                                var breakStrategy = tokens[1];

                                system.Display(breakStrategy);
                            } else {
                                System.out.println("Invalid Require command.");
                            }
                            break;
                        default:
                            System.out.println("Unknown command: " + command);
                    }
                }
            }
        } catch (Exception e) {
        }
    }
}
