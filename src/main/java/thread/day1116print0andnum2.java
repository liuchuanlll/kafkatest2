package thread;

/**
 * 方法执行 zero_even-zero-odd
 */

class ZeroEvenOdd2 {
    private int n;
    private Boolean ifZero=false;
    private int count=0;
    public ZeroEvenOdd2(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer2 printNumber) throws InterruptedException {
        for(int i=0;i<n;i++){
            synchronized (this){
                while(this.ifZero)
                    this.wait();
                printNumber.accept(0);
                this.ifZero=true;
                this.notifyAll();
            }
        }
    }
//输出2 4 6 8
    public void even(IntConsumer2 printNumber) throws InterruptedException {
        for(int i=2;i<=n;i+=2){
            synchronized (this){
                while(!this.ifZero||this.count%2==0)
                    this.wait();
                printNumber.accept(i);
                this.ifZero=false;
                this.count++;
                this.notifyAll();
            }
        }

    }
//输出 1 3 5 7
    public void odd(IntConsumer2 printNumber) throws InterruptedException {
        for(int i=1;i<=n;i+=2){
            synchronized (this){
                while(!this.ifZero||this.count%2==1)
                    this.wait();
                printNumber.accept(i);
                this.ifZero=false;
                this.count++;
                this.notifyAll();
            }
        }

    }

    public static void main(String[] args) {
        ZeroEvenOdd2 zeroEvenOdd=new ZeroEvenOdd2(8);
        IntConsumer2 intConsumer=new IntConsumer2();
        Thread a=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.zero(intConsumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread b=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.even(intConsumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread c=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.odd(intConsumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        a.start();b.start();c.start();
    }
}

class IntConsumer2 {
    public void accept(int num){
        System.out.print(num);
    }
}
