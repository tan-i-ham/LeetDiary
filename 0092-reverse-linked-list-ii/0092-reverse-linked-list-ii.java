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
// dummyHead
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode curr = dummyHead;
        ListNode prev = null;
        int idx=0;
        while(curr!=null && idx<=right){
            if(idx>=left){
                // start to reverse
                ListNode iCurr = curr; // inner current node
                ListNode iprev = null;

                while(iCurr!=null && idx<=right){
                    ListNode temp = iCurr.next;
                    iCurr.next = iprev;
                    iprev = iCurr;
                    iCurr = temp;
                    idx++;
                }
                prev.next = iprev;
                curr.next = iCurr;
            }else{
                prev = curr;
                curr = curr.next;
                idx++;
            }
        }
        return dummyHead.next;
    }
}
// 0    -1     null
// idx  curr   prev
// 1    1      -1
// 2    2      1
// 2   iCurr=2, iprev=null
// 3   iCurr=3, iprev=2
// 4   iCurr=4, iprev=3, iCurr=4
    