package thread;



public class day1114anxudayin {
    public static void main(String[] args) throws InterruptedException {
        Foo foo=new Foo();

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
                    Thread.sleep(100);
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
                    a.join();
                    Thread.sleep(100);
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
                    b.join();
                    foo.third(printThird);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        a.start();
        b.start();
        c.start();
    }
}
class Foo {

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

//public class Foo2 {
//    public void first() { System.out.print("first"); }
//    public void second() { System.out.print("second"); }
//    public void third() { System.out.print("third"); }
//}
//class a{
//    public static void main(String[] args) {
//        Foo2 foo2=new Foo2();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                foo2.first();
//            }
//        }).start();
//        其他俩线程同上
//    }
//}