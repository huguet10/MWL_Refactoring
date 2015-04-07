package intervals;

public class LeftOpenedInterval extends Interval {

    public LeftOpenedInterval(Point point, Opening opening) {
        super(point, opening);
    }

    @Override
    public boolean includes(double value) {
        return this.getMinimum() < value && value <= this.getMaximum();
    }

    @Override
    public boolean intersectsWith(Interval interval) {
        if (this.getMaximum() == interval.getMinimum()) {
            return interval.getOpening() == Opening.RIGHT_OPENED
                    || interval.getOpening() == Opening.UNOPENED;
        } else {
            return !this.matchWithEnd(interval)
                    && (this.includes(interval.getMinimum()) || this
                            .includes(interval.getMaximum()));
        }
    }

    @Override
    public boolean includes(Interval interval) {
        return interval.includes(this);
    }

    @Override
    public boolean includes(BothOpenedInterval interval) {
        boolean minimumIncluded = interval.includes(this.getMinimum());
        boolean maximumIncluded = interval.includes(this.getMaximum());
        return (minimumIncluded || this.getMinimum() == interval.getMinimum()) && (maximumIncluded);
    }

    @Override
    public boolean includes(UnopenedInterval interval) {
        boolean minimumIncluded = interval.includes(this.getMinimum());
        boolean maximumIncluded = interval.includes(this.getMaximum());
        return (minimumIncluded) && (maximumIncluded || interval.getMaximum() == this.getMaximum());
    }

    @Override
    public boolean includes(RightOpenedInterval interval) {
        boolean minimumIncluded = interval.includes(this.getMinimum());
        boolean maximumIncluded = interval.includes(this.getMaximum());
        return (minimumIncluded || interval.getMinimum() == this.getMinimum()) && (maximumIncluded);
    }

    @Override
    public boolean includes(LeftOpenedInterval interval) {
        boolean minimumIncluded = interval.includes(this.getMinimum());
        boolean maximumIncluded = interval.includes(this.getMaximum());
        return (minimumIncluded || interval.getMinimum() == this.getMinimum())
                && (maximumIncluded || interval.getMaximum() == this.getMaximum());
    }

}
