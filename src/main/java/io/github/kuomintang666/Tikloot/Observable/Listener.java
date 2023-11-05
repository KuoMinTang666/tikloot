package io.github.kuomintang666.Tikloot.observable;

public interface Listener<Type> {
    public static class Event {
        public static class ValueEvent extends Event {
            public static final ValueEvent EVENT_SET = new ValueEvent();
        }

        public static class ArrayEvent extends ValueEvent {
            public static final ArrayEvent EVENT_ADD = new ArrayEvent(), EVENT_REMOVE = new ArrayEvent();
        }
    }

    /**
     * 
     * @param event    Operation for observable
     * @param oldValue value before changed
     * @param newValue value after changed
     */
    public void Changed(Event event, Type oldValue, Type newValue);

}
