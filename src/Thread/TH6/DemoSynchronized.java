package TH6;

public class DemoSynchronized {
    public static synchronized void commonResource() {
        for (int i = 0; i < 10000000; i++) {
        }
    }

}

class Threadclass extends Thread {
    @Override
    public void run() {
        DemoSynchronized.commonResource();
    }
}

class ThreadMain {
    public static void main(String[] args) {
        Threadclass myThread1 = new Threadclass();
        Threadclass myThread2 = new Threadclass();
        Threadclass myThread3 = new Threadclass();
        myThread1.start();
        myThread2.start();
        myThread3.start();
        System.out.println(myThread1.getState());
        System.out.println(myThread2.getState());
        System.out.println(myThread3.getState());
    }
}

