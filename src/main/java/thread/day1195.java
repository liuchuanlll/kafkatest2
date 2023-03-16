package thread;

import java.util.concurrent.Semaphore;

public class day1195 {

    public static void main(String[] args) {
        FizzBuzz fizzBuzz=new FizzBuzz(16);
        Runnable printFizz=new Runnable() {
            @Override
            public void run() {
                System.out.println("fizz");
            }
        };
        Runnable printBuzz=new Runnable() {
            @Override
            public void run() {
                System.out.println("buzz");
            }
        };
        Runnable printFizzBuzz=new Runnable() {
            @Override
            public void run() {
                System.out.println("fizzbuzz");
            }
        };
        IntConsumer intConsumer = new IntConsumer();
        Thread a=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fizzBuzz.fizz(printFizz);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread b=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fizzBuzz.buzz(printBuzz);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread c=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fizzBuzz.fizzbuzz(printFizzBuzz);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread d=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fizzBuzz.number(intConsumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        a.start();b.start();c.start();d.start();
    }
}


class FizzBuzz {
    private int n;
    private Semaphore fSema = new Semaphore(0);
    private Semaphore bSema = new Semaphore(0);
    private Semaphore fbSema = new Semaphore(0);
    private Semaphore nSema = new Semaphore(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for(int i=3;i<=n;i+=3){
            if(i%15!=0){
                fSema.acquire();
                printFizz.run();
                nSema.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for(int i=5;i<=n;i+=5){
            if(i%15!=0){
                bSema.acquire();
                printBuzz.run();
                nSema.release();
            }

        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for(int i=15;i<=n;i+=15){
            fbSema.acquire();
            printFizzBuzz.run();
            nSema.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            nSema.acquire();
            if (i % 3 == 0 && i % 5 == 0) {
                fbSema.release();
            }else if (i % 3 == 0) {
                fSema.release();
            }else if (i % 5 == 0) {
                bSema.release();
            }else {
                printNumber.accept(i);
                nSema.release();
            }
        }
    }
}