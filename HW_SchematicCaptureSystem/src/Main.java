import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        var system = new MySystem();

        try {
//            var reader = new BufferedReader(new FileReader(args[0]));
            var reader = new BufferedReader(new FileReader("HW_SchematicCaptureSystem/src/Sample0.in"));

            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                var tokens = line.replaceAll("^\\s+", "").replaceAll("\\s+$", "").split(" ");
                if (tokens.length > 0) {
                    var command = tokens[0];
                    switch (command) {
                        case "<?xml", "<Question>":
                            break;
                        case "<Line/>":
                            system.addLine();
                            break;
                        case "<Text/>":
                            system.addText();
                            break;
                        case "<Rectangle/>":
                            system.addRectangle();
                            break;
                        case "<Group/>":
                            system.addEmptyGroup();
                            break;
                        case "<Group>":
                            system.startAddGroup();
                            break;
                        case "</Group>":
                            system.endAddGroup();
                            break;
                        case "</Question>":
                            system.draw();
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
