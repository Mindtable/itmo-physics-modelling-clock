package ru.itmo.clockmodelling.model;

public class ClockHand {

    private static final long STEP = 1;

    private final long radius;
    private final long period;


    private long time;

    public ClockHand(long radius, long period) {
        this.radius = radius;
        this.period = period;
        this.time = 0;
    }

    public double getX() {
        return radius * Math.sin(getAngle());
    }

    public double getY() {
        return radius * Math.cos(getAngle());
    }

    public void tick() {
        time += STEP;
        time %= period;
    }

    private double getAngle() {
        return time * 2 * Math.PI / period;
    }
}
