package TH6;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Ruunnable Start");
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Runnnable End ");
    }
}

class ClassThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread Start");
        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.start();
        try {
            myRunnableThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread End");
    }

    public static void main(String[] args) {
        ClassThread myThread = new ClassThread();

        myThread.start();

        try {
            Thread.sleep(100);
            System.out.println("MyThread State: " + myThread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
