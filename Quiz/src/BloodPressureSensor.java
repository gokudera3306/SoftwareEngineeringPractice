import java.io.*;
import java.util.ArrayList;

public class BloodPressureSensor extends FileBasedSensor {
    public BloodPressureSensor(String name, String fileName, double upperBound, double lowerBound) throws Exception {
        super(fileName, upperBound, lowerBound);

        this.info = new SensorInfo("BloodPressureSensor", name);
    }
}
