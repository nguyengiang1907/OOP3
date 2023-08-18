package Reflection.thuc_hanh_3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Calculator {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface DeprecatedAPI {
        String version() default "";
        String reason() default "";
    }
    public int add(int a,int b){
        return a+b;
    }
    @DeprecatedAPI(version = "1.0",reason = "Use 'add' method instead")
    public int sum(int a , int b){
        return a+b;
    }
}
class Main2{
    public static void main(String[] args) throws NoSuchMethodException {
        Calculator calculator = new Calculator();

        int result = calculator.add(2,3);
        System.out.println("Addition: "+result);

        if (Calculator.class.getMethod("sum" ,int.class, int.class).isAnnotationPresent(Calculator.DeprecatedAPI.class)) {
            System.out.println("Warning: This method is deprecated.");
            Calculator.DeprecatedAPI annotation = Calculator.class.getMethod("sum",int.class,int.class).getAnnotation(Calculator.DeprecatedAPI.class);
            System.out.println("Deprecated in version: "+annotation.version());
            System.out.println("Reason: "+annotation.reason());
        }
    }
}
