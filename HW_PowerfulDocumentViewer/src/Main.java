import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        var system = new MySystem();

        try {
//            var reader = new BufferedReader(new FileReader(args[0]));
            var reader = new BufferedReader(new FileReader("HW_PowerfulDocumentViewer/src/sampleInput"));

            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                var tokens = line.split(" ");
                if (tokens.length >= 1) {
                    var command = tokens[0];
                    switch (command) {
                        case "Present":
                            system.present();
                            break;
                        default:
                            var documentType = tokens[0];
                            system.addDocument(documentType);
                            break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid Input.");
        }
    }
}
