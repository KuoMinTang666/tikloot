package net.kuomintang666;

import org.junit.jupiter.api.Test;

import net.kuomintang666.Tikloot.Observable.ObservableValue;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ApplicationTest {

    @Test
    void test() {
        ObservableValue<String> value = new ObservableValue<>("bitch");
        value.setChangeListener((event, ov, nv) -> {
            System.out.println(ov);
            System.out.println(nv);
        });
        value.setValue("motherfucker");
    }
}
