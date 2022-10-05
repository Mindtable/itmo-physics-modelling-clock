package ru.itmo.clockmodelling;

import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.itmo.clockmodelling.factory.LineFactory;
import ru.itmo.clockmodelling.factory.PathFactory;
import ru.itmo.clockmodelling.model.Clock;
import ru.itmo.clockmodelling.model.ClockHand;
import ru.itmo.clockmodelling.view.vector.ChainedVectorView;
import ru.itmo.clockmodelling.view.vector.ClockHandView;
import ru.itmo.clockmodelling.view.vector.DummyChainedView;
import ru.itmo.clockmodelling.view.vector.TraceView;


public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @FXML
    private AnchorPane root;

    private Clock clock;

    private ChainedVectorView view;

    private Timer timer;
    @FXML
    protected void onHelloButtonClick() {
        if (view == null) {
            LineFactory lineFactory = LineFactory.getInstance(root);
            PathFactory pathFactory = PathFactory.getInstance(root);

            view = new DummyChainedView();

            Line line2 = new Line();
            root.getChildren().add(line2);

            view
                .addNext(new ClockHandView(lineFactory.create(), new ClockHand(25, 0)))
                .addNext(new ClockHandView(lineFactory.create(), new ClockHand(25, 200)))
                .addNext(new ClockHandView(lineFactory.create(), new ClockHand(25, 300)))
                .addNext(new ClockHandView(lineFactory.create(), new ClockHand(25, 50)))
                .addNext(new ClockHandView(lineFactory.create(), new ClockHand(25, 20)))
                .addNext(new TraceView(pathFactory.create(), 500))
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