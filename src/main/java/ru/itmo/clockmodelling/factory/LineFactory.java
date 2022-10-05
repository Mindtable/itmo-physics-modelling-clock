package ru.itmo.clockmodelling.factory;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class LineFactory extends NodeFactory {

    private static LineFactory instance;

    public LineFactory(Pane root) {
        super(root);
    }

    public static LineFactory getInstance(Pane pane) {
        if (instance == null) {
            instance = new LineFactory(pane);
        }

        return instance;
    }

    public Line create() {
        return (Line) addNode(new Line());
    }
}
