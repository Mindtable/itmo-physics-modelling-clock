package ru.itmo.clockmodelling.view.main;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.scene.layout.Pane;
import ru.itmo.clockmodelling.factory.LineFactory;
import ru.itmo.clockmodelling.factory.PathFactory;
import ru.itmo.clockmodelling.model.ClockHand;
import ru.itmo.clockmodelling.view.vector.ChainedVectorView;
import ru.itmo.clockmodelling.view.vector.ClockHandView;
import ru.itmo.clockmodelling.view.vector.DummyChainedView;
import ru.itmo.clockmodelling.view.vector.TraceView;

public class MainView {

    private static final int MAX_PATH_SIZE = 2500;

    private static final int FPS = 60;

    private final Pane root;

    private final ChainedVectorView view;

    private Timer timer;

    public MainView(Pane root, List<ClockHand> clockHands) {
        this.root = root;
        this.view = new DummyChainedView();

        LineFactory lineFactory = LineFactory.getInstance(root);
        PathFactory pathFactory = PathFactory.getInstance(root);

        var last = view;

        for (var hand : clockHands) {
            last = last.addNext(new ClockHandView(lineFactory.create(), hand));
        }

        last.addNext(new TraceView(pathFactory.create(), MAX_PATH_SIZE));
    }

    public void switchTimer() {
        if (timer == null) {
            startTimer();
        } else {
            finishTimer();
        }
    }

    private void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(
            new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(view::update);
                }
            },
            0, 1000 / FPS);
    }

    private void finishTimer() {
        timer.cancel();
        timer = null;
    }
}
