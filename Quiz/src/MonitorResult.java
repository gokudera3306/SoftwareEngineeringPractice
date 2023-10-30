public class MonitorResult {
    private final StatusCode status;
    private final String sensorName;
    private final double sensorData;

    public MonitorResult(StatusCode status, String sensorName, double sensorData) {
        this.status = status;
        this.sensorName = sensorName;
        this.sensorData = sensorData;
    }

    public double getSensorData() {
        return sensorData;
    }

    public StatusCode getStatus() {
        return status;
    }

    public String getSensorName() {
        return sensorName;
    }
}
