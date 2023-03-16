package leetcode;

public class day24两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        ListNode pre=new ListNode(-1);
        ListNode temp=pre;
        pre.next=head;
        while(head!=null&&head.next!=null){
            ListNode next=head.next;
            pre.next=next;//0->2
            head.next=next.next;
            next.next=head;//2->1
            pre=head;//pre=1
            head=head.next;//head=3 -0->2->1->3->4
        }
        return temp.next;
    }
}
