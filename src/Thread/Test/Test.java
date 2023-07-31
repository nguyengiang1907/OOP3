package Test;

import static java.lang.Thread.sleep;

public class Test extends Thread{
    @Override
    public void run(){
        long startTime  = System.currentTimeMillis();
        for (int i = 0; i <1000000 ; i++) {
            System.out.println(i);
        }
        try {
            sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("TRONG "+(endTime - startTime) /1000 + "s");
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.start();
    }
}
