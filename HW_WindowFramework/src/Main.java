import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        var system = new MySystem();

        try {
//            var reader = new BufferedReader(new FileReader(args[0]));
            var reader = new BufferedReader(new FileReader("HW_WindowFramework/src/sampleInput"));

            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                var tokens = line.split(" ");
                if (tokens.length > 0) {
                    var command = tokens[0];
                    switch (command) {
                        case "window":
                            var subType = tokens[1];
                            var impType = tokens[2];

                            system.createWindow(subType, impType);
                            break;
                        case "drawBorder":
                            system.drawBorder();
                            break;
                        case "drawCloseBox":
                            system.drawCloseBox();
                            break;
                        default:
                            throw new Exception("Unknown command: " + command);
                    }
                }
            }
        } catch (Exception e) {
        }
    }
}
