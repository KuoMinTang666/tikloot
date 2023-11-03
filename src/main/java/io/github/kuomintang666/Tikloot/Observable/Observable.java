package io.github.kuomintang666.Tikloot.observable;

import io.github.kuomintang666.Tikloot.observable.Listener.Event;

public class Observable<Type> {
    Listener<Type> ChangeListener;

    public Listener<Type> getChangeListener() {
        return ChangeListener;
    };

    public void setChangeListener(Listener<Type> listener) {
        ChangeListener = listener;
    };

}
