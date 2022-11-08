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
// without one pass: count the node, and loop again, stop when count to the N - n nodes, and point this node to the next next node
// === one pass ===
// assign a fast node first and loop point to next node n times
// assign a slow node, and fast & slow node loop together
// now, the slow node will be the node before the targetes node that we want to remove
// set it next to it next's next
// dH -> head -- n nodes -- fast
// dH -> head -- n nodes -- slow -- n nodes -- end -> fast
// e.g. even nodes: [1,2], n=1
// fast=1
// slow=1, return 1 -> null
// e.g. odd nodes: [1,2,3], n=1
// fast=1
// slow=2, return 1 -> 2 -> null
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode first = dummyHead;
        ListNode second = dummyHead;
        
    
        for(int i=1; i<= n+1; i++){
            first = first.next;
        }
        // betwenn second & first node, there are n nodes in between
        while(first!=null){
            first = first.next;
            second = second.next;
        }
        
        // because the constraints (at least 1 node), no checking null is fine
        second.next = second.next.next;
        return dummyHead.next;
    }
}