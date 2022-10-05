package ru.itmo.clockmodelling.factory;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

public abstract class NodeFactory {

    private static final int HEIGHT = 600;
    private static final int WIDTH = 800;

    private final Pane root;

    public NodeFactory(Pane root) {
        this.root = root;
    }

    protected Node addNode(Node node) {
        root.getChildren().add(node);

        node.setLayoutX(WIDTH / 2);
        node.setLayoutY(HEIGHT / 2);

        return node;
    }

    public abstract Node create();
}
