package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class day234回文链表 {
    public boolean isPalindrome(ListNode head) {
        LinkedList<ListNode> stack = new LinkedList<ListNode>();
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode curr=dummy;
        while (curr.next!=null){
            curr=curr.next;
            stack.push(curr);
        }
        curr=dummy;
        for(int i=0;i<=stack.size()/2;i++){
            if(stack.pop().val!=curr.next.val){
                return false;
            }
            curr=curr.next;
        }
        return true;
    }

}
