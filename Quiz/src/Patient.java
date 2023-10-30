import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Patient {
    private final String name;
    private final int frequency;
    private final LinkedList<Sensor> sensors;

    public Patient(String name, int frequency) {
        this.name = name;
        this.frequency = frequency;

        sensors = new LinkedList<>();
    }

    public void addSensor(Sensor newSensor) throws Exception {

        for (var s : sensors) {
            if (Objects.equals(s.getInfo().getName(), newSensor.getInfo().getName())) {
                throw new Exception("Can't have sensor with same name.");
            }
        }

        sensors.add(newSensor);
    }

    public boolean isMonitorTime(int currentTime) {
        return currentTime % frequency == 0;
    }

    public List<MonitorResult> ReadSensor() {
        var list = new LinkedList<MonitorResult>();

        for (var s : sensors) {
            var data = s.monitor();
            list.add(data);
        }

        return list;
    }

    public String getName() {
        return name;
    }

    public List<SensorInfo> getSensorInfos() {
        var list = new LinkedList<SensorInfo>();

        for (var s : sensors) {
            list.add(s.getInfo());
        }

        return list;
    }
}
