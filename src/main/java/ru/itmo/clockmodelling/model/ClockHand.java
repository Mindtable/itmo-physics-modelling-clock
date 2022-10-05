package ru.itmo.clockmodelling.model;

public class ClockHand {

    private final long radius;
    private final long period;

    private final long step;

    private long time;

    public ClockHand(long radius, long period, long step) {
        this.radius = radius;
        this.period = period;
        this.step = step;
        this.time = 0;

        if (step < 0) {
            throw new RuntimeException("Step cannot be less than zero");
        }
    }

    public double getX() {
        return radius * Math.sin(getAngle());
    }

    public double getY() {
        return radius * Math.cos(getAngle());
    }

    public void tick() {
        time += step;
        time %= period;
    }

    private double getAngle() {
        return time * 2 * Math.PI / period;
    }
}
