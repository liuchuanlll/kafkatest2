package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class day25K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        //dummy不变的节点，用来输出链表
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        //需要四个变动的节点
        ListNode pre=dummy;//上一个循环的最后节点
        ListNode start=head;//本循环的start
        ListNode end=dummy;//本循环的end
        ListNode next=null;//下个循环的开始节点
        int i=0;
        while(end.next!=null){
            end=end.next;
            i++;
            if(i%k==0) {
                next=end.next;//以上为将各节点到第一次反转的预备位置

                end.next=null;
                reverseList(start);//以上两行为反转

                pre.next=end;
                start.next=next;//以上两行把反转后的链表连起来

                //初始化下一次反转的初始节点、为下一次反转做准备
                pre=start;
                end=start;
                start=next;
            }
        }
        return dummy.next;//
    }
    public static ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode a= new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
//        ListNode listNode = reverseList(a,3);
        day25K个一组翻转链表 day25 = new day25K个一组翻转链表();
        ListNode listNode = day25.reverseKGroup(a, 3);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
