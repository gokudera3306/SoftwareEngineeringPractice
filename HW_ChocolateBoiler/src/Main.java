import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        var boiler = ChocolateBoiler.getInstance();

        try {
//            var reader = new BufferedReader(new FileReader(args[0]));
            var reader = new BufferedReader(new FileReader("HW_ChocolateBoiler/src/sampleInput"));

            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                var tokens = line.split(" ");

                var command = tokens[0];
                switch (command) {
                    case "Fill" -> boiler.fill();
                    case "Boil" -> boiler.boil();
                    case "Drain" -> boiler.drain();
                    default -> throw new Exception();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
