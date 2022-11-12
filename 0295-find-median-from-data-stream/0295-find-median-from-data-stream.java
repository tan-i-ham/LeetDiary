class MedianFinder {
    List<Integer> list;
    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        if(list.size() == 0){
            list.add(num);    
        }else{
            int l = 0;
            int r = list.size() - 1;
            while(l <= r){
                int mid = l + (r-l)/2; // prevent overflow
                if(list.get(mid) >= num){
                    r = mid-1;
                }else if(list.get(mid) < num){
                    l = mid+1;
                }
            }
            list.add(l, num);
        }
    }
    
    public double findMedian() {
        // Collections.sort(list);
        int size = list.size();
        if(size%2==0){
            return ((double)list.get(size/2) + (double)list.get(size/2 - 1))/2;
        }
        return list.get(size/2);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */