package ru.itmo.clockmodelling.view.vector;

import javafx.scene.shape.Path;
import ru.itmo.clockmodelling.view.util.PathFacade;

public class TraceView implements ChainedVectorView {

    private final PathFacade path;


    public TraceView(Path path, long maxSize) {
        this.path = new PathFacade(path, maxSize);
    }

    @Override
    public void update(double centerX, double centerY) {
        path.addPoint(centerX, centerY);
        path.updateFirstIfNeeded();
    }
}
