package Reflection.bai_tap_4;

public class Annotation {
    public void hienThi(){
        System.out.println("nguyen huu giang");
    }

}
class Annotation2 extends Annotation{
    @Override
    public void hienThi() {
        System.out.println("Nguyen Huu Giang");
    }
}
class ClassMain{
    public static void main(String[] args) {
        Annotation2 annotation2 = new Annotation2();
        annotation2.hienThi();
    }
}

