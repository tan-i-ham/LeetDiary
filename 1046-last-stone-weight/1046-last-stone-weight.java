// store every weight to maxHeap
// pick 2 elemeents to compare and smash, the left stone push again into the maxHeap
// return the left one if there is only one stone in the maxHeap
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone: stones){
            maxHeap.add(stone);
        }
        while(maxHeap.size() >= 2){
            int one = maxHeap.poll();
            int two = maxHeap.poll();
            maxHeap.add(Math.abs(one - two));
        }

        return maxHeap.poll();
    }
}

// TC: O(NlogN)
// SC: O(N)