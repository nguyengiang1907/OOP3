package BT3_SoNguyenTo;

import javax.swing.plaf.InsetsUIResource;

public class OptimizedPrimeFactorization extends Thread{
    public boolean isKiemTra(int number){
        if (number < 2){
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }

    @Override
    public void run() {
        int dem = 0;
        int batDau = 2;
        while (dem < batDau){
            if (isKiemTra(batDau)){
                System.out.println(getName()+" đã tìm ta " + batDau + " trong "  );
                dem++;
            }
            batDau++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
