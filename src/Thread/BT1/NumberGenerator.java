package BT1;

import TH1.Main;

public class NumberGenerator implements Runnable {
    private boolean first;
    public NumberGenerator(boolean first){
        this.first = first;
    }

    @Override
    public void run() {
        if (first) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("B");
            System.out.println(Thread.currentThread().getPriority());
        } else {
            System.out.println(Thread.currentThread().getPriority());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("A");
        }
    }

    public static void main(String[] args) {
        NumberGenerator numberGenerator1 = new NumberGenerator(true);
        NumberGenerator numberGenerator2 = new NumberGenerator(false);

        Thread thread1 = new Thread(numberGenerator1);
        Thread thread2 = new Thread(numberGenerator2);

        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
    }
}
