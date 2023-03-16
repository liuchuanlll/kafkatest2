package leetcode;

import java.util.Stack;

public class day19删除链表的倒数第N个结点 {
    //栈实现
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> stack=new Stack<ListNode>();
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        temp.next=head;
        stack.push(temp);
        int a=0;
        while(temp.next!=null){
            temp=temp.next;
            stack.push(temp);
            a++;
        }
        ListNode goal=new ListNode();
        for(int i=a;i>a-n;i--){
            goal = stack.pop();
        }
        ListNode pop = stack.pop();
        pop.next=goal.next;
        return dummy.next;
    }
    //快慢指针
    public static void main(String[] args) {
        ListNode a= new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        ListNode listNode = new day19删除链表的倒数第N个结点().removeNthFromEnd(a, 2);
       while(listNode!=null){
           System.out.println(listNode.val);
           listNode=listNode.next;
       }
    }
}
