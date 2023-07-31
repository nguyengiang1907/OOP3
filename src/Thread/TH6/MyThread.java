package TH6;

public class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("My Thread");
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println(myThread.getState());
    }
}
