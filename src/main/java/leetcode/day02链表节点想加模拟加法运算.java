package leetcode;

import java.util.LinkedList;


// Definition for singly-linked list.
  class ListNode {
     int val;
     ListNode next;
     ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


public class day02链表节点想加模拟加法运算 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root=new ListNode();
        ListNode tail=root;
        if(l1==null){return l2;
        }else if(l2==null){return l1;}
        while(l1!=null&&l2!=null){
            tail.next=new ListNode(l1.val+l2.val);
            l1=l1.next;
            l2=l2.next;
            tail=tail.next;
        }
        if(l1!=null) {tail.next=l1;}
        else if(l2!=null) {tail.next=l2;}

        int a=0;//十位数上的值
        ListNode temp=root.next;
        while (temp!=null){
            int t=temp.val;
            temp.val=(t+a)%10;
            a=(t+a)/10;
            if(temp.next==null){//判断temp是否是最后一个
                break;//是的话跳出当前循环
            }else{
                temp=temp.next;//否则temp跳到下一个节点
            }
        }
        if(a!=0){temp.next=new ListNode(a);}
        return  root.next;
    }

    public static void main(String[] args) {
        ListNode Node1=new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9)))));

        ListNode Node2=new ListNode(9,new ListNode(9,new ListNode(9)));

        ListNode listNode = addTwoNumbers(Node1, Node2);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resListNode = new ListNode(-1);
        ListNode resListNodeTemp = resListNode;
        int temp = 0;
        while (l1 != null && l2 != null) {
            resListNodeTemp.next = new ListNode((l1.val + l2.val + temp) % 10);//求余数
            temp = (l1.val + l2.val + temp) / 10;//求得数
            l1 = l1.next;
            l2 = l2.next;
            resListNodeTemp = resListNodeTemp.next;
        }

        while (l1 != null) {
            resListNodeTemp.next = new ListNode((l1.val + temp) % 10);
            temp = (l1.val + temp) / 10;
            l1 = l1.next;
            resListNodeTemp = resListNodeTemp.next;
        }
        while (l2 != null) {
            resListNodeTemp.next = new ListNode((l2.val + temp) % 10);
            temp = (l2.val + temp) / 10;
            l2 = l2.next;
            resListNodeTemp = resListNodeTemp.next;
        }
        if (l1 == null && l2 == null && temp != 0) {
            resListNodeTemp.next = new ListNode(temp);
        }

        return resListNode.next;
    }
}