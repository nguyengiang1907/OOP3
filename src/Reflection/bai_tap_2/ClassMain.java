package Reflection.bai_tap_2;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ClassMain {
    public static void main(String[] args) throws NoSuchMethodException {
        Class<?> newClass = MyClass.class;
        System.out.println("Name Class: " + newClass.getName());
        Method[] methods = newClass.getMethods();
        for (Method method : methods
        ) {
            System.out.println(method.getName());
        }
        // nhập phương thức muốn kiểm tra
        Method method = MyClass.class.getMethod("sum");
        Method method2 = MyClass.class.getMethod("min");
        // sử dụng phương thức MOdifieer.isStatic để kiểm tra xem có phải là Static hay khong
        System.out.println("Static method: " +method.getName() +" "+ Modifier.isStatic(method.getModifiers()));
        System.out.println("Static method: " +method2.getName()+" "+ Modifier.isStatic(method2.getModifiers()));

    }
}
