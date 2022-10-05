package ru.itmo.clockmodelling.factory;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Path;

public class PathFactory extends NodeFactory {

    private static PathFactory instance;

    public static PathFactory getInstance(Pane pane) {
        if (instance == null) {
            instance = new PathFactory(pane);
        }

        return instance;
    }

    public PathFactory(Pane root) {
        super(root);
    }


    public Path create() {
        Path node = new Path();

        node.setLayoutX(400);
        node.setLayoutY(300);

        return (Path) addNode(node);
    }
}
