package thread;



public class day1114anxudayin2 {
    public static void main(String[] args) throws InterruptedException {
        Foo2 foo=new Foo2();

        Runnable printFirst=new Runnable() {
            @Override
            public void run() {
                System.out.println("one");
            }
        };
        Runnable printSecond=new Runnable() {
            @Override
            public void run() {
                System.out.println("second");
            }
        };
        Runnable printThird=new Runnable() {
            @Override
            public void run() {
                System.out.println("third");
            }
        };
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    foo.first(printFirst);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    foo.second(printSecond);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.third(printThird);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        c.start();

        a.start();

        b.start();
    }
}
class Foo2 {
    private  int a=0;
//synchronized    wait  notifyall
    public Foo2() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        System.out.println();
        synchronized(this){
            while(a!=0) this.wait();
            System.out.println("A获得了锁");
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            a++;
            this.notifyAll();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {
        System.out.println();
        synchronized(this){
            System.out.println("B获得了锁");
            while(a!=1) this.wait();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            a++;
            this.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        System.out.println();
        synchronized (this){
            System.out.println("C获得了锁");
            while(a!=2) this.wait();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            a++;
            this.notifyAll();
        }

    }
}

