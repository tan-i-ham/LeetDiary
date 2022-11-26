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
// create a var, prev, to remember what is the previous node to make current node's next property to the prev node(reverse purpose)
// create a current node var, to remember what node are we at
// start the while loop, the stop condition is when curr is null
// and we return prev as the result
// in the loop, create a temp var for curr and curr.next connection is broke
// te temp is for the preparation for update the curr node
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}