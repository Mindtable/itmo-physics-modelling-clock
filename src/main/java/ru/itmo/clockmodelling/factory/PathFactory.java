package ru.itmo.clockmodelling.factory;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;

public class PathFactory extends NodeFactory {

    private static PathFactory instance;

    public PathFactory(Pane root) {
        super(root);
    }

    public static PathFactory getInstance(Pane pane) {
        if (instance == null) {
            instance = new PathFactory(pane);
        }

        return instance;
    }

    public Path create() {
        Path node = new Path();

        node.setStroke(Color.AQUA);

        return (Path) addNode(node);
    }
}
