/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode intersect = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                intersect = slow;
                break;
            }

        }
        if(intersect == null) {
            return null;
        }
        ListNode h = head;
        while(h != intersect){
            h = h.next;
            intersect = intersect.next;
        }
        return intersect;
    }
}