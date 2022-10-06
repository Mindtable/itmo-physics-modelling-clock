package ru.itmo.clockmodelling;

import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.itmo.clockmodelling.model.ClockHand;
import ru.itmo.clockmodelling.view.main.MainView;
import ru.itmo.clockmodelling.view.main.MainViewSingleton;


public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @FXML
    private AnchorPane root;

    private MainView view;

    @FXML
    protected void onInitButtonClick() {
        var hands = List.of(
            new ClockHand(50, 3600),
            new ClockHand(50, 60)
//            new ClockHand(50, -1000),
//            new ClockHand(50, 500),
//            new ClockHand(50, -500),
//            new ClockHand(50, 250)
        );

        view = MainViewSingleton.getInstance(root, hands);
    }

    @FXML
    protected void onPlayButtonClick() {
        if (view == null) {
            onInitButtonClick();
        }

        view.switchTimer();
    }
}