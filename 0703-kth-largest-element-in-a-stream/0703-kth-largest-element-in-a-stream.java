class KthLargest {
    // create a minHeap, that has k elements only
    // create a maxHeap to store the other elements when nums array has number of elements that larger than k
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    int K;
    
    // the constructor
    // TC: O(NlogN) , N is the length of given array
    // SC: O(N)
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        // minHeap = new PriorityQueue<>( (a, b) -> Integer.compares(b, a));
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        K = k;
        for(int num: nums){
            add(num);
        }
    }
    // TC: O(logN)
    // SC: O(N)    
    public int add(int val) {
        if(minHeap.size() < K){
            minHeap.add(val);    
        }else{
            if(minHeap.peek() < val){
                maxHeap.add(minHeap.poll());
                minHeap.add(val);
            }else{
                maxHeap.add(val);
            }
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */