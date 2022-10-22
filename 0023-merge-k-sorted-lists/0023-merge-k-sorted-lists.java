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
// first, put every head nodes of lists[i] in the pq
// while loop: top element is the node who has the min val
// the end condition is when pq is empty
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int N = lists.length;
        if(N==0){
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode prevNode = dummyHead;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>( (n1, n2) -> Integer.compare(n1.val, n2.val) );
        
        for(int i=0; i< N; i++){    
            if(lists[i] != null){
                pq.offer(lists[i]);
            }
        }
        while(!pq.isEmpty()){
            ListNode curr = pq.poll();
            prevNode.next = curr;
            prevNode = prevNode.next;
            if(curr.next!=null){
                pq.offer(curr.next);    
            }
        }
        return dummyHead.next;
    }
}
// [1,1,2]
// prev    curr    pq
// -1      1       [1,2,4]
// 1       1       [2,3,4]
// 1       2       [3,4,6]
// 2       3       [4,4,6]
// 3       4       [4,5,6]
// 4       4       [5,6]
// 4       5       [6]
// 5       6       []



// TC: O(M): M is the number of total nodes in the lists
// SC: O(1)