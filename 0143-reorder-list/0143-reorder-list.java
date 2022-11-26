/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        // 1. find the middle node first by using fast and slow technique
        while(fast != null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode l2 = slow.next;
        slow.next = null; // split the first and second half, important!!!
        
        ListNode curr = l2; // 3
        ListNode prev = null;
        // 2. reverse the second half node
        while(curr!=null){
            ListNode temp = curr.next; // 4, null
            curr.next = prev; // 3-> n, 4->3->null
            prev = curr; // 
            curr = temp; // 4
        }
        l2 = prev;
        
        ListNode c1 = head;
        ListNode c2 = l2;
        // 3. connect each node one by one
        while(c1!=null && c2!=null){
            ListNode t1 = c1.next;
            ListNode t2 = c2.next;
            c1.next = c2;
            c2.next = t1;
            c1 = t1;
            c2 = t2;
        }
    }
}