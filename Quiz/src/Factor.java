public class Factor {
    private final int timeStamp;
    private final double data;

    public Factor(int timeStamp, double data) {
        this.timeStamp = timeStamp;
        this.data = data;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public double getData() {
        return data;
    }
}
