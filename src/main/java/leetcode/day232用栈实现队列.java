package leetcode;

import java.util.*;

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
public  class day232用栈实现队列 {

    Stack<Integer> stackA=new Stack<>();
    Deque<Integer> stackB= new LinkedList();
    public day232用栈实现队列() {

    }

    public void push(int x) {
        stackA.push(x);
    }

    // 从队列的开头移除并返回元素
    public int pop() {
        if (stackB.isEmpty()){
            while(!stackA.isEmpty())
                stackB.push(stackA.pop());
        }
        int num = stackB.pop();
        return num;
    }
    //返回队列开头的元素
    public int peek() {
        if (stackB.isEmpty()){
            while(!stackA.isEmpty())
                stackB.push(stackA.pop());
        }
        int num = stackB.peek();
        return num;
    }

    public boolean empty() {
        return stackA.empty()&&stackB.isEmpty();
    }

    public static void main(String[] args) {
//        Deque<Integer> deque=new ArrayDeque<Integer>();
//        Deque<Integer> queue= new LinkedList();
//        deque.push(1);
//        deque.push(2);
//        System.out.println(deque.peek());
//        System.out.println(deque.pop());
        day232用栈实现队列 myQueue = new day232用栈实现队列();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek());; // return 1
        System.out.println(myQueue.pop());; // return 1, queue is [2]
        myQueue.empty(); // return false
    }
}

