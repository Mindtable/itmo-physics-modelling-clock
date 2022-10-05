package ru.itmo.clockmodelling.view;

import javafx.scene.shape.Line;
import ru.itmo.clockmodelling.model.ClockHand;

public class ClockHandView implements ChainedVectorView {

    private final Line clockHand;
    private final ClockHand model;
    private ChainedVectorView next;


    public ClockHandView(Line clockHand, ClockHand model) {
        this.clockHand = clockHand;
        this.model = model;

        clockHand.setLayoutX(400);
        clockHand.setLayoutY(300);
    }

    @Override
    public void update(double centerX, double centerY) {
        clockHand.setStartX(centerX);
        clockHand.setStartY(centerY);

        model.tick();

        var newX = model.getX();
        var newY = -model.getY();

        clockHand.setEndX(centerX + newX);
        clockHand.setEndY(centerY + newY);

        if (next != null) {
            next.update(centerX + newX, centerY + newY);
        }
    }

    @Override
    public ChainedVectorView addNext(ChainedVectorView next) {
        this.next = next;

        return next;
    }
}
