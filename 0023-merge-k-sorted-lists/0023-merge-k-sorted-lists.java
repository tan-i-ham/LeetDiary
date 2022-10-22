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
// the outer loop try to pick the min node from all the heads of lists
// connect the prevNode next to the one is picked
// set prevNode to the one is picked
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int N = lists.length;
        if(N==0){
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode prevNode = dummyHead;
        
        while(true){
            int idx=0;
            while(idx< N && lists[idx] == null){
                idx++;
            }
            if(idx==N){
                break;
            }
            int minIdx = idx;

            for(int i=idx+1; i< N; i++){    
                if(lists[i] != null && lists[i].val < lists[minIdx].val){
                    minIdx = i;
                }
            }
            prevNode.next = lists[minIdx];
            prevNode = prevNode.next;
            lists[minIdx] = lists[minIdx].next;
        }
        return dummyHead.next;
    }
}

// minIdx  prevNode
// 0       1       lists[0]=4
// 1       1       lists[1]=3
// 2       2       lists[2]=6
// 1       3       lists[1]=4
// 0       4       lists[0]=5
// 1       4       lists[1]=null    
// 0       5       lists[0]=null   
// 2       6       lists[2]=null