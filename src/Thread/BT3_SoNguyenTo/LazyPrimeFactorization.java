package BT3_SoNguyenTo;

public class LazyPrimeFactorization extends Thread {
    public boolean isStatus(int number) {
        if (number < 2) {
            return false;
        }
        int squareRoot = (int) Math.sqrt(number);
        for (int i = 2; i <= squareRoot; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void run() {
        int dem = 0;
        int batDau = 2;
        while (dem < batDau) {
            if (isStatus(batDau)) {
                System.out.println(getName() + " đã tìm ra số " + batDau);
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

    public static void main(String[] args) {
        LazyPrimeFactorization l = new LazyPrimeFactorization();
        l.start();
    }
}
