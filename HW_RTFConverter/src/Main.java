import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        var myReader = new Reader();

        try {
//            var reader = new BufferedReader(new FileReader(args[0]));
            var reader = new BufferedReader(new FileReader("HW_RTFConverter/src/sampleInput"));

            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                var tokens = line.split(" ");

                var command = tokens[0];
                switch (command) {
                    case "TeX", "TextWidget" -> myReader.setConverter(command);
                    default -> myReader.convert(tokens[0]);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
