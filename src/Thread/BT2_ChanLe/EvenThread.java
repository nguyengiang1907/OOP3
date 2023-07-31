package BT2_ChanLe;

public class EvenThread extends Thread{
    @Override
    public void run(){
        for (int i = 0; i <=10 ; i+=2) {
            System.out.println(i);
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class TestThread{
    public static void main(String[] args) {
        OddThread oddThread = new OddThread();
        EvenThread evenThread = new EvenThread();

        oddThread.start();
        try {
            oddThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        evenThread.start();
    }
}
