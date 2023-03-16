package leetcode;

public class day876链表的中间结点 {
    //注意链表长度为偶数时，返回第 2个结点的细节
    public ListNode middleNode(ListNode head) {
        ListNode fast=head;
        ListNode mid=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            mid=mid.next;
        }
        return mid;
    }
    //注意链表长度为偶数时，返回第 1个结点的细节
    public ListNode middleNode2(ListNode head) {
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        ListNode a= new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,new ListNode(6))))));
        day876链表的中间结点 day876 = new day876链表的中间结点();
        ListNode listNode = day876.middleNode(a);
        System.out.println(listNode.val);
    }
}
