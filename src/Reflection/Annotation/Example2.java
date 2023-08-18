package Reflection.Annotation;

public class Example2 {
    public static void main(String[] args) {
        @SuppressWarnings("deprecation")
        DeprecatedAnnotation newObject =new  DeprecatedAnnotation();
        newObject.method1();
        newObject.method2();
    }
}

class DeprecatedAnnotation {
    public void method1() {
        System.out.println("Hello tuan anh");
    }
    @Deprecated
    public void method2(){
        System.out.println("Hello tu anh");
    }
}

