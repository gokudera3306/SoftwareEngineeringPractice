import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        var system = new MySystem();

        try {
            var reader = new BufferedReader(new FileReader(args[0]));
//            var reader = new BufferedReader(new FileReader("src/sampleInput1"));

            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                var tokens = line.split(" ");
                if (tokens.length > 0) {
                    var command = tokens[0];
                    switch (command) {
                        case "data":
                            if (tokens.length == 3) {
                                var item = tokens[1];
                                var value = Integer.parseInt(tokens[2]);

                                system.AddData(item, value);
                            } else {
                                System.out.println("Invalid data command.");
                            }
                            break;
                        case "addChart":
                            if (tokens.length == 2) {
                                var chartType = tokens[1];

                                system.AddChart(chartType);
                            } else {
                                System.out.println("Invalid addChart command.");
                            }
                            break;
                        case "change":
                            if (tokens.length == 4) {
                                var chartType = tokens[1];
                                var item = tokens[2];
                                var value = Integer.parseInt(tokens[3]);

                                system.ChangeData(chartType, item, value);
                            } else {
                                System.out.println("Invalid change command.");
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
