package ru.itmo.clockmodelling;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.itmo.clockmodelling.util.ConfigReader;
import ru.itmo.clockmodelling.view.main.MainView;
import ru.itmo.clockmodelling.view.main.MainViewSingleton;


public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @FXML
    private AnchorPane root;

    private MainView view;

    @FXML
    protected void onPlayButtonClick() {
        if (view == null) {
            initView();
        }

        view.switchTimer();
    }

    private void initView() {
        var hands = ConfigReader.readConfig();

        view = MainViewSingleton.getInstance(root, hands);
    }
}