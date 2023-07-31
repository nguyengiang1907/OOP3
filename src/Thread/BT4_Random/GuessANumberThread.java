package BT4_Random;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.LinkedTransferQueue;

public class GuessANumberThread extends Thread {
    long startTime = System.currentTimeMillis();

    private int guessNumber = 0;
    private int count = 0;

    public GuessANumberThread(int guessNumber) {
        this.guessNumber = guessNumber;
    }

    @Override
    public void run() {
        int randomNumber = 0;
        do {
            randomNumber = (int) (Math.random() * 10 + 1);
            count++;
            System.out.println(getName() +" vừa đoán số " + randomNumber);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (guessNumber != randomNumber);
        long endTime = System.currentTimeMillis();
            System.out.println(getName() + " đã đoán số " + randomNumber + " trong " + count + " lần " + (endTime - startTime) /1000 +"s");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số : ");
        int number = scanner.nextInt();

        GuessANumberThread thread1 = new GuessANumberThread(number);
        GuessANumberThread thread2 = new GuessANumberThread(number);

        thread1.setName("Người chơi 1");
        thread2.setName("Người chơi 2");

        thread1.start();
        thread2.start();
    }
}
