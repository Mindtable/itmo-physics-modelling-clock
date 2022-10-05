package ru.itmo.clockmodelling.view.main;

import java.util.List;
import javafx.scene.layout.Pane;
import ru.itmo.clockmodelling.model.ClockHand;

public class MainViewSingleton {

    private static MainView instance;

    public static MainView getInstance(Pane root, List<ClockHand> clockHands) {
        if (instance == null) {
            instance = new MainView(root, clockHands);
        }

        return instance;
    }
}
