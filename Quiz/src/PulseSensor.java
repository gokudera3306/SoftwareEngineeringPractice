import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class PulseSensor extends FileBasedSensor {
    public PulseSensor(String name, String fileName, double upperBound, double lowerBound) throws Exception {
        super(fileName, upperBound, lowerBound);

        this.info = new SensorInfo("PulseSensor", name);
    }
}