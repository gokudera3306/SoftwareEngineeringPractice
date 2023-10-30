import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var system = new MySystem();

        try {
//            var reader = new BufferedReader(new FileReader(args[0]));
            var reader = new BufferedReader(new FileReader("src/Sample0.in"));

            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                var tokens = line.split(" ");

                if (tokens.length == 0) continue;

                var command = tokens[0];
                switch (command) {
                    case "Person" -> {
                        if (tokens.length == 5) {
                            var name = tokens[1];
                            var job = tokens[2];
                            var weight = tokens[3];
                            var height = tokens[4];

                            system.AddPerson(name, job, weight, height);
                        } else {
                            System.out.println("Invalid Person command.");
                        }
                    }
                    case "Job" -> {
                        if (tokens.length == 2) {
                            var name = tokens[1];

                            system.DisplayJob(name);
                        } else {
                            System.out.println("Invalid Job command.");
                        }
                    }
                    case "WeightAverage" -> {
                        if (tokens.length >= 2) {
                            List<String> names = new ArrayList<>(Arrays.asList(tokens).subList(1, tokens.length));

                            system.DisplayWeightAvg(names);
                        } else {
                            System.out.println("Invalid WeightAverage command.");
                        }
                    }
                    case "WeightSum" -> {
                        if (tokens.length >= 2) {
                            List<String> names = new ArrayList<>(Arrays.asList(tokens).subList(1, tokens.length));

                            system.DisplayWeightSum(names);
                        } else {
                            System.out.println("Invalid WeightSum command.");
                        }
                    }
                    case "HeightAverage" -> {
                        if (tokens.length >= 2) {
                            List<String> names = new ArrayList<>(Arrays.asList(tokens).subList(1, tokens.length));

                            system.DisplayHeightAvg(names);
                        } else {
                            System.out.println("Invalid HeightAverage command.");
                        }
                    }
                    case "HeightSum" -> {
                        if (tokens.length >= 2) {
                            List<String> names = new ArrayList<>(Arrays.asList(tokens).subList(1, tokens.length));

                            system.DisplayHeightSum(names);
                        } else {
                            System.out.println("Invalid HeightSum command.");
                        }
                    }
                    default -> System.out.println("Unknown command: " + command);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
