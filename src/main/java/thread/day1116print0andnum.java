package thread;

/**
 * 三个方法轮流执行，只不过其中一个判断是否输出,方法执行 zero-even-odd-zero-even-odd-zero-even-odd
 */
class ZeroEvenOdd {
    private int n;
    private int count=0;
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=0;i<n;i++){
            synchronized (this){
                while(this.count%3!=0)
                    this.wait();
                printNumber.accept(0);
                this.count++;
                this.notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=0;i<n;i++){
            synchronized (this){
                while(this.count%3!=1)
                    this.wait();
                if((i+1)%2==1){
                    printNumber.accept(i+1);
                }
                this.count++;
                this.notifyAll();
            }
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=0;i<n;i++){
            synchronized (this){
                while(this.count%3!=2)
                    this.wait();
                if((i+1)%2==0){
                    printNumber.accept(i+1);
                }
                this.count++;
                this.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd=new ZeroEvenOdd(8);
        IntConsumer intConsumer=new IntConsumer();
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

class IntConsumer {
    public void accept(int num){
        System.out.print(num);
    }
}