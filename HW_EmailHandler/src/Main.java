import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        var system = new MySystem();

        try {
//            var reader = new BufferedReader(new FileReader(args[0]));
            var reader = new BufferedReader(new FileReader("HW_EmailHandler/src/Sample.in"));

            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                var tokens = line.split(" ");
                if (tokens.length > 0) {
                    var command = tokens[0];

                    system.ReceiveEmail(command);
                }
            }
        } catch (Exception e) {
        }
    }
}
