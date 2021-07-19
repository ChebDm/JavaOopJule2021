public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        if (from > to) {
            throw new IllegalArgumentException("Range start coordinate must be less than or equal to end coordinate");
        }
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double x) {
        return from <= x && x <= to;
    }

    public boolean isCommonPointsExist(Range r) {
        return isInside(r.from) || isInside(r.to) || ((r.from < from) && (r.to > to));
    }

    @Override
    public String toString() {
        return "(" + from + ", " + to + ")";
    }

    public Range getIntersectedRange(Range examinedRange) {
        if (!isIntersected(examinedRange)) {
            return null;
        } else {
            double newFrom = Math.max(examinedRange.from, from);
            double newTo = Math.min(examinedRange.to, to);

            return new Range(newFrom, newTo);
        }
    }

    private boolean isIntersected(Range examinedRange) {
        return examinedRange.getTo() > from && examinedRange.getFrom() < to;
    }

    public Range[] getUnion(Range examinedRange) {
        if (!isCommonPointsExist(examinedRange)) {
            Range[] ranges = new Range[2];

            Range range1 = new Range(examinedRange.from, examinedRange.to);
            Range range2 = new Range(this.from, this.to);

            if (examinedRange.from < from) {
                ranges[0] = range1;
                ranges[1] = range2;
            } else {
                ranges[0] = range2;
                ranges[1] = range1;
            }
            return ranges;
        }

        return new Range[]{new Range(Math.min(examinedRange.from, from), Math.max(examinedRange.to, to))};
    }
}