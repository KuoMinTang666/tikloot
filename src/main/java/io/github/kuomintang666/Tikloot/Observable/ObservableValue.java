package io.github.kuomintang666.Tikloot.observable;

import io.github.kuomintang666.Tikloot.observable.Listener.Event;

public class ObservableValue<Type> extends Observable<Type> {
    private Type Value;

    public ObservableValue() {
    }

    public ObservableValue(Type v) {
        Value = v;
    }

    public ObservableValue(Type v, Listener<Type> l) {
        Value = v;
        ChangeListener = l;
    }

    /**
     * 
     * @return source value
     */
    public Type getValue() {
        return Value;
    }

    /**
     * 
     * @param value target value
     */
    public void setValue(Type value) {
        Type old = Value;
        Value = value;
        Changed(Listener.Event.ValueEvent.EVENT_SET, old, value);
    }

    /**
     * 
     * @param event    event type
     * @param oldValue value before changing
     * @param newValue value after changing
     */
    protected void Changed(Event event, Type oldValue, Type newValue) {
        if (ChangeListener != null)
            ChangeListener.Changed(event, oldValue, newValue);
    };
}
