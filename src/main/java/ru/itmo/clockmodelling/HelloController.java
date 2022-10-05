package ru.itmo.clockmodelling;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.itmo.clockmodelling.model.Clock;


public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @FXML
    private Circle circle;

    @FXML
    private Line line;

    @FXML
    private Path path;

    private Clock clock;



    @FXML
    protected void onHelloButtonClick() {
        if (clock == null) {

            path.setStroke(Color.BLUE);

            path.setLayoutX(400);
            path.setLayoutY(300);

            line.setLayoutX(400);
            line.setLayoutY(300);

            clock = new Clock(-10, 0, 200, 3600, line, path);
        }

        if (clock.isWorking()) {
            clock.stop();
        } else {
            clock.startTimer(60);
        }

        LOGGER.info("Coordinates " + clock.getX() + " " + clock.getY());
        LOGGER.info("Button pressed");
    }

    @FXML
    protected void onTestButtonClick() {
        Path trace = new Path();
        trace.getElements().add(new MoveTo(100, 100));
        trace.getElements().add(new LineTo(120, 100));
        trace.getElements().add(new LineTo(100, 120));
        trace.setStroke(Color.BLUE);
    }
}