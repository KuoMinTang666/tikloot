package net.kuomintang666.Tikloot.Observable;

import net.kuomintang666.Tikloot.Observable.Listener.Event;

public class Observable<Type> {
    Listener<Type> ChangeListener;

    public Listener<Type> getChangeListener() {
        return ChangeListener;
    };

    public void setChangeListener(Listener<Type> listener) {
        ChangeListener = listener;
    };

}
