package Reflection.bai_tap_1_constructor;

import java.lang.reflect.Constructor;
import java.util.Arrays;

public class ClassMain {
    public static void main(String[] args) throws ClassNotFoundException {
        // Truy vấn đến Class
        Class<?> newClass = new MyClass().getClass();
        // in ra tên Class
        System.out.println("Name class: " + newClass.getName());
        // Khởi tạo phương thức để lấy Constructor
        Constructor<?>[] constructors = newClass.getConstructors();
        System.out.println("Constructors: ");
        for (Constructor<?> cons : constructors
        ) {
            System.out.println(" - " + cons.getName());
            System.out.println(" + " + Arrays.toString(cons.getParameterTypes()));
        }
    }
}
