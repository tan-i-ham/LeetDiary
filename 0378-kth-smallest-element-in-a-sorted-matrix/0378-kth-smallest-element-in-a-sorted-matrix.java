// push all the elements in minHeap
// pop k-1 times
// return pop one more time and return this element
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int[] row: matrix){
            for(int ele: row){
                minHeap.add(ele);
            }
        }
        
        for(int i=0; i<k-1; i++){
            minHeap.poll();
        }
        return minHeap.poll();
    }
}
// TC: O(M*N), M is the length of row, N is the length of col
// SC: O(M*N)