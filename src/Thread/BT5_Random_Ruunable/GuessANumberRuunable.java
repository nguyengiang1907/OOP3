package BT5_Random_Ruunable;


import java.util.Scanner;

public class GuessANumberRuunable implements Runnable {
    private int dem = 0;
    private int nhap = 0;
    public GuessANumberRuunable(int nhap){
        this.nhap=nhap;
    }
    int ngauNhien =0;
    long startTime = System.currentTimeMillis();
    @Override
    public void run() {
        do {
            ngauNhien = (int) (Math.random() * 100 + 1);
            System.out.println(Thread.currentThread().getName() + "vừa đoán ra số " + ngauNhien );
            dem++;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }while (nhap != ngauNhien);
        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "vừa đoán ra số " + ngauNhien + " trong " + dem + " lần trong " +(endTime - startTime) / 1000 + "s" );
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so doan");
        int input = scanner.nextInt();

        GuessANumberRuunable guessANumberRuunable = new GuessANumberRuunable(input);
        GuessANumberRuunable guessANumberRuunable2 = new GuessANumberRuunable(input);

        Thread thread1 =new Thread(guessANumberRuunable);
        Thread thread2 =new Thread(guessANumberRuunable2);

        thread1.setName("Người chơi 1 ");
        thread2.setName("Người chơi 2 ");

        thread1.start();
        thread2.start();
    }
}