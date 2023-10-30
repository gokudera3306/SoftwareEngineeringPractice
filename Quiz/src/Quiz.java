import java.io.BufferedReader;
import java.io.FileReader;

public class Quiz {
    public static void main(String[] args) {
        var m = new Program();

        int totalPeriod = 0;

        try {
            var reader = new BufferedReader(new FileReader(args[0]));
//            var reader = new BufferedReader(new FileReader("SampleTestCases/Sample0.in"));

            String data;
            Patient currentPatient = null;
            while ((data = reader.readLine()) != null && !data.isEmpty()) {
                var tokens = data.split(" ");
                if (tokens.length >= 2) {
                    switch (tokens[0]) {
                        case "patient" -> {
                            var name = tokens[1];
                            var period = Integer.parseInt(tokens[2]);

                            if (currentPatient != null) {
                                m.addPatient(currentPatient);
                            }

                            if (period < 0)
                                throw new Exception("Can't be negative.");

                            currentPatient = new Patient(name, period);
                        }
                        case "BloodPressureSensor" -> {
                            var sensorName = tokens[1];
                            var fileName = tokens[2];
                            var lowerBound = Integer.parseInt(tokens[3]);
                            var upperBound = Integer.parseInt(tokens[4]);

                            if (lowerBound < 0 || upperBound < 0)
                                throw new Exception("Can't be negative.");

                            var newSensor = new BloodPressureSensor(sensorName, fileName, upperBound, lowerBound);
                            currentPatient.addSensor(newSensor);
                        }
                        case "PulseSensor" -> {
                            var sensorName = tokens[1];
                            var fileName = tokens[2];
                            var lowerBound = Integer.parseInt(tokens[3]);
                            var upperBound = Integer.parseInt(tokens[4]);

                            if (lowerBound < 0 || upperBound < 0)
                                throw new Exception("Can't be negative.");

                            var newSensor = new PulseSensor(sensorName, fileName, upperBound, lowerBound);
                            currentPatient.addSensor(newSensor);
                        }
                        case "TemperatureSensor" -> {
                            var sensorName = tokens[1];
                            var fileName = tokens[2];
                            var lowerBound = Integer.parseInt(tokens[3]);
                            var upperBound = Integer.parseInt(tokens[4]);

                            if (lowerBound < 0 || upperBound < 0)
                                throw new Exception("Can't be negative.");

                            var newSensor = new TemperatureSensor(sensorName, fileName, upperBound, lowerBound);
                            currentPatient.addSensor(newSensor);
                        }
//                        default -> throw new Exception("Not recognize.");
                    }
                } else {
                    totalPeriod = Integer.parseInt(tokens[0]);

                    if (totalPeriod < 0)
                        throw new Exception("Can't be negative.");
                }
            }

            m.addPatient(currentPatient);

        } catch (Exception e) {
//            System.out.println(e.getMessage());

            System.out.println("Input Error");
        }

        m.StartSystem(totalPeriod);
    }
}
