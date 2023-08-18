package Reflection.Annotation;

public class SuperExampleNMD {
    public void methodOverride(){
        System.out.println("SupperClass Nguyen Huu Giang ");
    }
}
class ExampleNMD extends SuperExampleNMD{
    @Override
    public void methodOverride() {
        System.out.println("SubClass Nguyen Huu Giang 1");
    }
}
class MainNMD {
    public static void main(String[] args) {
        ExampleNMD ex = new ExampleNMD();
        ex.methodOverride();
    }
}
