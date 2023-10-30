import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public abstract class FileBasedSensor extends AbstractSensor {
    private final ArrayList<Double> readerData;
    private int currentReaderIndex = 0;

    public FileBasedSensor(String fileName, double upperBound, double lowerBound) throws Exception {
        super(upperBound, lowerBound);

        readerData = new ArrayList<>();

        File fakeDataFile = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fakeDataFile));

            String data;
            while((data = reader.readLine())!=null && !data.isEmpty()) {
                var number = Double.parseDouble(data);
                readerData.add(number);
            }
        } catch (Exception e) {
            System.out.println("Can't Read File: " + fileName);
            throw new Exception(e);
        }
    }

    @Override
    public MonitorResult monitor() {
        if (currentReaderIndex >= readerData.size()) {
            return new MonitorResult(StatusCode.SensorFail, info.getName(), -1);
        }

        var currentData = readerData.get(currentReaderIndex);
        currentReaderIndex++;

        StatusCode status;
        if (currentData == -1) {
            status = StatusCode.SensorFail;
        } else if (!range.IsInRange(currentData)) {
            status = StatusCode.Danger;
        } else {
            status = StatusCode.Normal;
        }

        return new MonitorResult(status, info.getName(), currentData);
    }
}
