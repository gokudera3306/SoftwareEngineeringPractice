public class Range {
    protected final double upperBound;
    protected final double lowerBound;

    public Range(double upperBound, double lowerBound) {
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
    }

    boolean IsInRange(double value) {
        return value <= upperBound && value >= lowerBound;
    }
}
