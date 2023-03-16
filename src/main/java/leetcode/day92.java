package leetcode;

public class day92 {
    public static ListNode reverseList(ListNode head, int left, int right) {
        int foot=0;
        ListNode curr=head;
        ListNode pre=null;
        for(int i = 1; i < left; i++){
            pre=curr;
            curr = curr.next;
        }
        ListNode  mid=curr;
        pre.next=null;
        ListNode next=null;
        for(int i = left; i <= right; i++){
            next=curr;
            curr = curr.next;
        }
        ListNode  tail=curr;
        next.next=null;
        day206反转链表.reverseList(mid);
        pre.next=next;
        mid.next=tail;
        return head;
    }

    public static void main(String[] args) {
        ListNode a= new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        ListNode listNode = reverseList(a,2,4);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
