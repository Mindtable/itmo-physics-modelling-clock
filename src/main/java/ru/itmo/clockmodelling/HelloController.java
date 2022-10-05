package ru.itmo.clockmodelling;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import javafx.application.Platform;
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
import ru.itmo.clockmodelling.model.ClockHand;
import ru.itmo.clockmodelling.view.ChainedVectorView;
import ru.itmo.clockmodelling.view.ClockHandView;
import ru.itmo.clockmodelling.view.DummyChainedView;
import ru.itmo.clockmodelling.view.TraceView;


public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @FXML
    private Circle circle;

    @FXML
    private Line line;

    @FXML
    private Line line1;

    @FXML
    private Line line11;

    @FXML
    private Path path;

    private Clock clock;

    private ChainedVectorView view;

    private Timer timer;

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
        if (view == null) {
            view = new DummyChainedView();
            view
                .addNext(new ClockHandView(line11, new ClockHand(25, -67)))
                .addNext(new ClockHandView(line, new ClockHand(100, 127)))
                .addNext(new ClockHandView(line1, new ClockHand(50, 500)))
                .addNext(new TraceView(path, 500))
            ;
        }

        startTimer(1);
    }

    public void startTimer(long step) {
        timer = new Timer();
        timer.scheduleAtFixedRate(
            new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(
                        () -> {
                            view.update(0, 0);
                        }
                    );
                }
            },
            0, 1000 / 60);
    }
}