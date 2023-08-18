package Reflection.bai_tap_3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassMain {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Class<?> newClass = MyClass.class;
        System.out.println("Class Name: " + newClass.getName());

        MyClass myClass = new MyClass();
        Method[] methods = newClass.getMethods();
        for (Method method : methods
        ) {
            method.invoke(myClass.min(7,9));
        }
    }
}
