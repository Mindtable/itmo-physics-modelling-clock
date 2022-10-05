package ru.itmo.clockmodelling.view.util;

import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class PathFacade {

    private final Path path;
    private final long maxSize;

    public PathFacade(Path path, long maxSize) {
        this.path = path;
        this.maxSize = maxSize;
    }

    public void addPoint(double x, double y) {
        var elements = path.getElements();

        if (elements.isEmpty()) {
            elements.add(new MoveTo(x, y));
        } else {
            elements.add(new LineTo(x, y));
        }
    }

    public void updateFirstIfNeeded() {
        var elements = path.getElements();

        if (elements.size() > maxSize) {
            elements.remove(1, 2);
            LineTo pathElement = (LineTo) elements.get(1);
            elements.set(0, new MoveTo(pathElement.getX(), pathElement.getY()));
        }
    }
}
