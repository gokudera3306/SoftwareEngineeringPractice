public class SensorInfo {
    private final String type;
    private final String name;

    public SensorInfo(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
