class KthLargest {
    // create a minHeap, that has k elements only
    PriorityQueue<Integer> minHeap;
    int K;
    
    // the constructor
    // TC: O(NlogN) , N is the length of given array
    // SC: O(N)
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        
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
                minHeap.poll();
                minHeap.add(val);
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