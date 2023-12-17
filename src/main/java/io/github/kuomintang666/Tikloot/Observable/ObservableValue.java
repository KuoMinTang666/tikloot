package io.github.kuomintang666.Tikloot.observable;

import io.github.kuomintang666.Tikloot.observable.Observable.Listener.Event;

public class ObservableValue<Type> implements Observable<Type> {
    private Type value;
    private Listener<Type> changeListener = (e, o, n) -> {
    };

    public ObservableValue() {
    }

    public ObservableValue(Type v) {
        value = v;
    }

    public ObservableValue(Type v, Listener<Type> l) {
        value = v;
        changeListener = l;
    }

    /**
     * 
     * @return value
     */
    public Type getvalue() {
        return value;
    }

    /**
     * 
     * @param value target value
     */
    public void setvalue(Type value) {
        Type old = value;
        this.value = value;
        changed(Listener.Event.ValueEvent.EVENT_SET, old, value);
    }

    /**
     * 
     * @param event    event type
     * @param oldvalue value before changing
     * @param newvalue value after changing
     */
    protected void changed(Event event, Type oldvalue, Type newvalue) {
        if (changeListener != null)
            changeListener.changed(event, oldvalue, newvalue);
    }

    public ObservableValue<Type> clone() {
        ObservableValue<Type> clone = new ObservableValue<>();
        clone.changeListener = this.changeListener;
        clone.value = this.value;
        return clone;
    }

    @Override
    public Listener<Type> getChangeListener() {
        return changeListener;
    }

    @Override
    public void setChangeListener(Listener<Type> listener) {
        this.changeListener = listener;
    }

}
