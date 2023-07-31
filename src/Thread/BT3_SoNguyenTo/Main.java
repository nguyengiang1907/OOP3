package BT3_SoNguyenTo;

public class Main {
    public static void main(String[] args) {
        LazyPrimeFactorization thread1 = new LazyPrimeFactorization();
        OptimizedPrimeFactorization thread2 = new OptimizedPrimeFactorization();
        thread1.setName("Thread 1 : ");
        thread2.setName("Thread 2 : ");
        thread2.start();
        thread1.start();

    }

}
