package ru.itmo.clockmodelling.view;

public class DummyChainedView implements ChainedVectorView {

    private ChainedVectorView next;

    @Override
    public void update(double centerX, double centerY) {
        if (next != null) {
            next.update(centerX, centerY);
        }
    }

    @Override
    public ChainedVectorView addNext(ChainedVectorView next) {
       this.next = next;

       return next;
    }
}
