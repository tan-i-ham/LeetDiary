class MedianFinder {
    PriorityQueue<Integer> minHeap; // to store larger half
    PriorityQueue<Integer> maxHeap; // to store smaller half
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        int lHalfSize = minHeap.size();
        int sHalfSize = maxHeap.size(); 
        if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        }  
        return (Double.valueOf(maxHeap.peek()) + Double.valueOf(minHeap.peek())) /2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */