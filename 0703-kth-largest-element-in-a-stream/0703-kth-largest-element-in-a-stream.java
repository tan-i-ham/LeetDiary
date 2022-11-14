class KthLargest {
    PriorityQueue<Integer> minHeap;
    int K;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        K = k;
        
        for(int num: nums){
            if(minHeap.size() < k){
                minHeap.offer(num);
                continue;
            }
            if(minHeap.size()>=k && num > minHeap.peek()){
                minHeap.poll();
                minHeap.offer(num);
            }
            
        }
    }
    
    public int add(int val) {
        if(minHeap.size() < K){
            minHeap.offer(val); 
        }else if(val > minHeap.peek()){
            minHeap.poll();
            minHeap.offer(val);   
        }
            
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */