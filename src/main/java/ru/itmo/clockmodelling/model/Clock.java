package ru.itmo.clockmodelling.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.itmo.clockmodelling.HelloController;

public class Clock {

    private static final Logger LOGGER = LoggerFactory.getLogger(Clock.class);

    private final double centerX;
    private final double centerY;
    private final double radius;
    private final long period;

    private long time = 0;

    public Clock(double centerX, double centerY, double radius, long period) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.period = period;
    }

    public void makeStep(double step) {
        time += step;
        while (Math.abs(time) >= period) {
            time -= time > 0 ? period : -period;
        }

        LOGGER.info("New time is " + time);
    }

    public double getX() {
        return centerX + radius * Math.sin(getAngle());
    }

    public double getY() {
        return centerY - radius * Math.cos(getAngle());
    }

    private double getAngle() {
        return time * 2 * Math.PI / period;
    }

}
