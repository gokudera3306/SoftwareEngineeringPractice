import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var system = new GUIApplication();

        try {
//            var reader = new BufferedReader(new FileReader(args[0]));
            var reader = new BufferedReader(new FileReader("HW_GUIApplication/src/sampleInput"));

            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                var tokens = line.split(" ");

                if (tokens.length == 0) continue;

                var command = tokens[0];
                switch (command) {
                    case "Motif", "PM" -> system.switchStyle(command);
                    case "Present" -> system.present();
                    default -> {
                        if (tokens.length != 2)
                            throw new Exception("Unknown Command");

                        system.addWidget(tokens[0], tokens[1]);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
