package thread;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class pdd {
    public static  void main(String[] args) throws InterruptedException {
         Object locka=new Object();
         Object lockb=new Object();
        Semaphore semaphore_1=new Semaphore(0);
        Semaphore semaphore_2=new Semaphore(0);
        Thread a=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (locka){
                    System.out.println("a.locka");
                    semaphore_1.release();
                    try {
                        semaphore_2.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lockb){
                        System.out.println("a.lockb");
                    }
                }
            }
        });
        Thread b=new Thread(new Runnable() {
            public void run() {
                synchronized (lockb){
                    System.out.println("b.lockb");
                    semaphore_2.release();
                    try {
                        semaphore_1.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (locka){
                        System.out.println("b.locka");
                    }
                }
            }
        });
        a.start();
        b.start();
    }
}


//或者直接semaphore_1.acqure  2.release
//2.acqure()  semaphore_1.release()