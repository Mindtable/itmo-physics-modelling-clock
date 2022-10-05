package ru.itmo.clockmodelling.view;

import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class TraceView implements ChainedVectorView {

    private final Path path;

    private final long maxSize;

    public TraceView(Path path, long maxSize) {
        this.path = path;
        this.maxSize = maxSize;
    }

    @Override
    public void update(double centerX, double centerY) {
        if (path.getElements().isEmpty()) {
            path.getElements().add(new MoveTo(centerX, centerY));
        }

        if (path.getElements().size() > maxSize) {
            path.getElements().remove(1, 2);

            LineTo pathElement = (LineTo) path.getElements().get(1);
            path.getElements().set(0, new MoveTo(pathElement.getX(), pathElement.getY()));
        }

        path.getElements().add(new LineTo(centerX, centerY));
    }
}
