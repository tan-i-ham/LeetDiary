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
// compare the head pointers of two lists in every steps in the loop while interating
// the head who has smaller value should update the head to head.next
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(list1 != null || list2 != null){
            if(list1 == null){
                curr.next = list2;
                list2 = list2.next;
                break;
            }
            if(list2 == null){
                curr.next = list1;
                list1 = list1.next;
                break;
            }
            if(list1.val <= list2.val){
                curr.next = list1;
                list1 = list1.next;
            }else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
