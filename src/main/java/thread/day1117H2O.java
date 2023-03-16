package thread;

import kotlin.jvm.Volatile;

import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class day1117H2O {
//    CyclicBarrier  AbstractQueuedSynchronizer
    public static void main(String[] args) {
        H2O h2o = new H2O();
        Runnable releaseHydrogen=new Runnable() {
            @Override
            public void run() {
                System.out.print("H");
            }
        };
        Runnable releaseOxygen=new Runnable() {
            @Override
            public void run() {
                System.out.print("O");
            }
        };
        String waters = "OHH";

        for (int i = 0; i < waters.length(); i++) {
            int finalI = i;
            new Thread(()->{
                if(waters.charAt(finalI)=='H'){
                    try {
                        h2o.hydrogen(releaseHydrogen);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else if(waters.charAt(finalI)=='O'){
                    try {
                        h2o.oxygen(releaseOxygen);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    throw new RuntimeException("'water' must consist of values in ['H', 'O'] only");
                }
            }).start();
        }
    }
}

class H2O {
    private Semaphore hSemaphore=new Semaphore(2);
    private Semaphore oSemaphore=new Semaphore(1);
    CyclicBarrier cb=new CyclicBarrier(3);

    public H2O() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hSemaphore.acquire();

        try {
            cb.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        releaseHydrogen.run();
        hSemaphore.release();

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oSemaphore.acquire();

        try {
            cb.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        releaseOxygen.run();
        oSemaphore.release();
    }


}
