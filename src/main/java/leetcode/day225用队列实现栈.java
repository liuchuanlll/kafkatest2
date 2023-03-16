package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class day225用队列实现栈 {
    Queue<Integer> queueA=new LinkedList<Integer>();

//    offer  poll
    public day225用队列实现栈() {

    }

    public void push(int x) {
        Queue<Integer> queueB=new LinkedList<Integer>();
        queueB.offer(x);
        while(!queueA.isEmpty()){
            queueB.offer(queueA.poll());
        }
        queueA=queueB;
    }

    public void push2(int x) {
        queueA.offer(x);
        for(int i=0;i<queueA.size()-1;i++){
            queueA.offer(queueA.poll());
        }
    }

    public int pop() {
        return queueA.poll();
    }

    public int top() {
        return queueA.peek();
    }

    public boolean empty() {
        return queueA.isEmpty();
    }

}
