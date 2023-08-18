package Reflection.bai_tap_1_constructor;

import javax.swing.plaf.PanelUI;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class MyClass {

    public int publicField;
    private String privateField;


    public MyClass() {
    }

    public MyClass(int publicField) {

    }

    public MyClass(int publicField, String privateField) {

    }
}
