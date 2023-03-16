package thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class day1226Philosophers {
//    Lock writeLock2=new ReentrantReadWriteLock().writeLock();
//    Lock readLock=new ReentrantReadWriteLock().readLock();

}
class DiningPhilosophers {
    Semaphore eatLimit = new Semaphore(4);//限制 最多只有4个哲学家去持有叉子
    Lock[] locks={new ReentrantLock(),new ReentrantLock(),new ReentrantLock(),new ReentrantLock(),new ReentrantLock()};
    //1个Fork视为1个ReentrantLock，5个叉子即5个ReentrantLock，将其都放入数组中
    public DiningPhilosophers() {

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        eatLimit.acquire();
        int leftFork = (philosopher + 1) % 5;    //左边的叉子 的编号
        int rightFork = philosopher;    //右边的叉子 的编号
        locks[leftFork].lock();    //拿起左边的叉子
        locks[rightFork].lock();    //拿起右边的叉子
        pickLeftFork.run();    //拿起左边的叉子 的具体执行
        pickRightFork.run();    //拿起右边的叉子 的具体执行

        eat.run();    //吃意大利面 的具体执行

        putLeftFork.run();    //放下左边的叉子 的具体执行
        putRightFork.run();    //放下右边的叉子 的具体执行

        locks[leftFork].unlock();    //放下左边的叉子
        locks[rightFork].unlock();    //放下右边的叉子

        eatLimit.release();//限制的人数 +1


    }
}