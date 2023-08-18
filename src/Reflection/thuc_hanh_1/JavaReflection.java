package Reflection.thuc_hanh_1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class JavaReflection {
    public int publicField;
    private String privateField;

    public JavaReflection() {
    }

    public void publicMethod() {
    }

    private void privateMethod() {
    }

    public static void main(String[] args) {
        // Lấy tên class
        Class<?> newClass = new JavaReflection().getClass();
        System.out.println("Class name "+newClass.getName());

        // Truy xuất thông tin modifiers
        int modifiers = newClass.getModifiers();
        System.out.println("Modifiers: "+modifiers);

        // Truy xuất các trường public của lớp
        Field[] fields = newClass.getFields();
        System.out.println("Public Fields :");
        for (Field field : fields
             ) {
            System.out.println(" - " + field.getName());
        }

        // Truy xuất các phương thức public của lớp
        Method[] methods = newClass.getMethods();
        System.out.println("Public Methods: ");
        for (Method method: methods
             ) {
            System.out.println("- "+method.getName());
        }
        Constructor<?>[] constructors = newClass.getConstructors();
        System.out.println("Public constructors: ");
        for (Constructor<?> constructor: constructors
             ) {
            System.out.println("- "+constructor.getName());
        }
    }
}
