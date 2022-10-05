package ru.itmo.clockmodelling.view;

public interface ChainedVectorView {
    void update(double centerX, double centerY);

    default void update() {
        update(0, 0);
    }

    ChainedVectorView addNext(ChainedVectorView next);
}