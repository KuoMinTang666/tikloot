package io.github.kuomintang666.Tikloot.observable;

public class Observable<Type> {
    Listener<Type> ChangeListener;

    public Listener<Type> getChangeListener() {
        return ChangeListener;
    };

    public void setChangeListener(Listener<Type> listener) {
        ChangeListener = listener;
    };

}
