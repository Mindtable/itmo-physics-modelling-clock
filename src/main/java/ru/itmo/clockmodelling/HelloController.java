package ru.itmo.clockmodelling;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.itmo.clockmodelling.model.Clock;


public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @FXML
    private Circle circle;

    @FXML
    private Line line;

    private final Clock clock = new Clock(-25, 0, 59, 8);

    @FXML
    protected void onHelloButtonClick() {
        clock.makeStep(1);

        line.setEndX(clock.getX());
        line.setEndY(clock.getY());

        LOGGER.info("Coordinates " + clock.getX() + " " + clock.getY());
        LOGGER.info("Button pressed");
    }
}