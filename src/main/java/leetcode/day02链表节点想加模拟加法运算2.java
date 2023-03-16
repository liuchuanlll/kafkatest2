package leetcode;

import java.util.LinkedList;

/**
 * @author kfzx-liuc02
 * @version 1.0
 * @date 2022/4/1 10:04
 * @Description
 */
class ListNode2 {
    int data;
    ListNode2 next;
    public ListNode2(int data){
        this.data=data;
    }
    public void addNodea(ListNode2 newNode) {
        if(this.next==null){
            this.next=newNode;
        } else {
            this.next.addNodea(newNode);
        }
        LinkedList list=new LinkedList<Character>();
        list.removeFirst();
    }

    public int getData() {
        return data;
    }

    public ListNode2 getNext() {
        return next;
    }
}



public class day02链表节点想加模拟加法运算2 {
    ListNode2 head=null,tail=null;

    public ListNode2 SumNodea(ListNode2 l1, ListNode2 l2){
    int carry=0;
    while (l1!=null||l2!=null){
        int n1=l1==null?0:l1.data;
        int n2=l2==null?0:l1.data;
        int sum=n1+n2+carry;
        if(head==null){
            head=tail=new ListNode2(sum%10);
        }else{
            tail.next=new ListNode2(sum%10);
            tail=tail.next;
        }
        carry=sum/10;
        if(l1!=null){l1=l1.next;}
        if(l2!=null){l2=l2.next;}
    }
    if(carry>0){
        tail.next=new ListNode2(carry);
    }
        return head;
    }

    public static ListNode2 SumNodeRecur(ListNode2 l1, ListNode2 l2,int bit){
        if(l1==null&&l2==null&&bit==0){
            return null;
        }
        int val=bit;
        if(l1!=null){
            val=val+l1.data;
            l1=l1.next;
        }
        if(l2!=null){
            val=val+l2.data;
            l2=l2.next;
        }
        ListNode2 node =new ListNode2(val%10);
        node.next=SumNodeRecur(l1,l2,val/10);
        return node;
    }

    public static void main(String[] args) {
        ListNode2 lista=new ListNode2(3);
        lista.addNodea(new ListNode2(9));
        ListNode2 listb=new ListNode2(3);
        listb.addNodea(new ListNode2(9));
        listb.addNodea(new ListNode2(9));
        ListNode2 listNode = SumNodeRecur(lista, listb, 0);
        Print(listNode);
    }
    public static void Print(ListNode2 node){
        if(node !=null){
            System.out.println(node.getData());
            Print(node.getNext());
        }
    }
}