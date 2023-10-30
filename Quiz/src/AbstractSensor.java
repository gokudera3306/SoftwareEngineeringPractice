public abstract class AbstractSensor implements Sensor {
    protected SensorInfo info;
    protected final Range range;

    public AbstractSensor(double upperBound, double lowerBound) throws Exception {
        this.range = new Range(upperBound, lowerBound);

        if (upperBound < lowerBound)
            throw new Exception("Upper should larger then Lower.");
    }

    @Override
    public final SensorInfo getInfo() {
        return info;
    }
}
