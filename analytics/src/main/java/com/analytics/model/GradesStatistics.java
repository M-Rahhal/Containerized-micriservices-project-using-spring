package com.analytics.model;

public class GradesStatistics{
    private double min;
    private double max;
    private double avg;

    public GradesStatistics() {
    }

    public GradesStatistics(double min, double max, double avg) {
        this.min = min;
        this.max = max;
        this.avg = avg;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }
}
