package leetcode;

import javax.swing.*;
import java.util.Stack;

public class day160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stacka=new Stack<>();
        Stack<ListNode> stackb=new Stack<>();
        ListNode tempA=headA;
        ListNode tempB=headB;
        while(tempA!=null){
            stacka.push(tempA);
            tempA=tempA.next;
        }
        while(tempB!=null){
            stackb.push(tempB);
            tempB=tempB.next;
        }
        ListNode result=null;
        while(!stacka.empty()&&!stackb.empty()){
            ListNode a = stacka.pop();
            ListNode b = stackb.pop();
            if(!a.equals(b)){
                return a.next;
            }
        }
        return stacka.empty()?headA:headB;
    }

    public static void main(String[] args) {
        ListNode listNode=new ListNode(8,new ListNode(4,new ListNode(5)));
        ListNode listNode1=new ListNode(4);
        ListNode listNode2=new ListNode(1);
        listNode1.next=listNode2;
        listNode2.next=listNode;
        ListNode listNode3=new ListNode(5);
        ListNode listNode4=new ListNode(6);
        ListNode listNode5=new ListNode(1);
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        listNode5.next=listNode;
        ListNode intersectionNode = new day160().getIntersectionNode(listNode1, listNode3);
        System.out.println(intersectionNode.val);
    }
}
