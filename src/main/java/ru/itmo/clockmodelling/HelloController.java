package ru.itmo.clockmodelling;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @FXML
    private Circle circle;

    @FXML
    protected void onHelloButtonClick() {
        circle.setRadius(ThreadLocalRandom.current().nextInt(1, 10) * 10);
        circle.setCenterX(ThreadLocalRandom.current().nextInt(-400, 400));
        circle.setCenterY(ThreadLocalRandom.current().nextInt(-300, 300));

        LOGGER.info("Button pressed");
    }
}