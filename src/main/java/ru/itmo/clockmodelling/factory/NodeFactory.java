package ru.itmo.clockmodelling.factory;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public abstract class NodeFactory {

    private Pane root;

    public NodeFactory(Pane root) {
        this.root = root;
    }

    protected Node addNode(Node node) {
        root.getChildren().add(node);

        return node;
    }

    public abstract Node create();
}
