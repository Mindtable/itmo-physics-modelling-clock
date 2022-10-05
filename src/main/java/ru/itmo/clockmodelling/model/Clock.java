package ru.itmo.clockmodelling.model;

import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.itmo.clockmodelling.HelloController;

public class Clock {

    private static final Logger LOGGER = LoggerFactory.getLogger(Clock.class);

    private final double centerX;
    private final double centerY;
    private final double radius;
    private final long period;

    private Line line;
    private Path root;

    private long time = 0;

    private boolean isWorking = false;

    private Timer timer = new Timer();

    public Clock(double centerX, double centerY, double radius, long period, Line line, Path root) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.period = period;
        this.line = line;
        this.root = root;

//        root.setLayoutX(centerX);
//        root.setLayoutY(centerY);
        line.setStartX(centerX);
        line.setStartY(centerY);
    }

    public void makeStep(long step) {

        time += step;
        time %= period;

        if (root.getElements().size() > period / step) {
            root.getElements().remove(1, 2);

            LineTo pathElement = (LineTo) root.getElements().get(1);
            root.getElements().set(0, new MoveTo(pathElement.getX(), pathElement.getY()));

        }
    }

    public double getX() {
        return radius * Math.sin(getAngle());
    }

    public double getY() {
        return -radius * Math.cos(getAngle());
    }

    public void startTimer(long step) {
        timer = new Timer();
        timer.scheduleAtFixedRate(
            new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(
                        () -> {
                            makeStep(step);

                            if (root.getElements().isEmpty()) {
                                root.getElements().add(new MoveTo(getX(), getY()));
                            } else if (!(root.getElements().get(0) instanceof MoveTo)) {
                                root.getElements().set(0, new MoveTo(getX(), getY()));
                            }

                            line.setEndX(getX());
                            line.setEndY(getY());

                            root.getElements().add(new LineTo(getX(), getY()));
                        }
                    );
                }
            },
        0, 1000 * step / period);
        isWorking = true;
    }

    public void stop() {
        isWorking = false;
        timer.cancel();
    }

    public boolean isWorking() {
        return isWorking;
    }

    private double getAngle() {
        return time * 2 * Math.PI / period;
    }

}
