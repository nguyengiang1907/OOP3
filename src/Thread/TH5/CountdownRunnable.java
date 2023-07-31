package TH5;

public class CountdownRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 10 ; i >= 1 ; i-- ){
            System.out.println(i);
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
class Main{
    public static void main(String[] args) {
        CountdownRunnable countdownRunnable = new CountdownRunnable();
        Thread contdownThread = new Thread(countdownRunnable);
        contdownThread.start();
    }
}