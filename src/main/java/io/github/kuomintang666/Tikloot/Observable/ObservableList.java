package io.github.kuomintang666.Tikloot.Observable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import io.github.kuomintang666.Tikloot.Observable.Listener.Event;
import io.github.kuomintang666.Tikloot.Utils.ArrayUtil;

public class ObservableList<Type> extends ObservableValue<List<Type>> {
    List<Type> list = new ArrayList<>();

    /**
     * 
     * @param element element what is added
     * @param index   element index
     */
    public void add(Type element, int index) {
        List<Type> old = ArrayUtil.cloneList(list);
        list.add(index, element);
        Changed(Event.ArrayEvent.EVENT_ADD, old, list);
    }

    /**
     * 
     * @param element element what is set
     * @param index   element index
     */
    public void set(Type element, int index) {
        List<Type> old = ArrayUtil.cloneList(list);
        list.set(index, element);
        Changed(Event.ArrayEvent.EVENT_SET, old, list);
    }

    /**
     * 
     * @param element element what is removed
     * @param index   element index
     */

    public void remove(Type element) {
        List<Type> old = ArrayUtil.cloneList(list);
        list.remove(element);
        Changed(Event.ArrayEvent.EVENT_SET, old, list);
    }

    /**
     * 
     * @param index element index
     */

    public void remove(int index) {
        List<Type> old = ArrayUtil.cloneList(list);
        list.remove(index);
        Changed(Event.ArrayEvent.EVENT_SET, old, list);
    }

    /**
     * 
     * @return Iterator of this list
     */
    public Iterator<Type> getIterator() {
        return list.iterator();
    }

    /***
     * 
     * @param consumer consumer what need all element
     */
    public void forEach(Consumer<Type> consumer) {
        for (Type type : list) {
            consumer.accept(type);
        }
    }

    /**
     * 
     * @param element element what is added
     */
    public void add(Type element) {
        add(element, list.size());
    }
}
