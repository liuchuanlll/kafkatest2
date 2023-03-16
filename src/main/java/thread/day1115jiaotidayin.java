package thread;

public class day1115jiaotidayin {
    public static void main(String[] args) {
        FooBar fooBar=new FooBar(8);
        Runnable printFoo=new Runnable() {
            @Override
            public void run() {
                System.out.println("foo");
            }
        };
        Runnable printBar=new Runnable() {
            @Override
            public void run() {
                System.out.println("bar");
            }
        };
        Thread a=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.foo(printFoo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread b=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.bar(printBar);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
a.start();
b.start();
    }
}


class FooBar {
    private int n;
    private boolean isFoo=false;
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this){
                while(isFoo)
                    this.wait();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                isFoo=true;
                this.notifyAll();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this){
                while(!isFoo)
                    this.wait();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                isFoo=false;
                this.notifyAll();
            }

        }
    }
}