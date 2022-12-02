// use maxHeap to store the stone
// first put every stone to the maxHeap
// pop 2 element if the size is >= 2
// if same than no new element put into it
// after smash, add the (m1 - m2) into maxHeap
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int s: stones){
            maxHeap.add(s);
        }
        while(maxHeap.size()>=2){
            int m1 = maxHeap.poll();
            int m2 = maxHeap.poll();
            if(m1 == m2){
                continue;
            }
            maxHeap.add(m1-m2);
        }
        return maxHeap.size()==0 ? 0 : maxHeap.poll();
    }
}
// [2,7,4,1,8,1]
// maxHeap = [8,7,4,2,1,1]
// maxHeap = [4,2,1,1,1]
// maxHeap = [2,1,1,1]
// maxHeap = [1,1,1]
// maxHeap = [1]