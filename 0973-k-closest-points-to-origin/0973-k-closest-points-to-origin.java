class Solution {
    // create a maxHeap to store K points based on the given array
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>( (a, b) -> Integer.compare(
            b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1]
        ));

        for(int[] point: points){
            int x = point[0];
            int y = point[1];
            int dist = x * x + y * y;
            maxHeap.add(point);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
            
        }
        int[][] ans = new int[k][2];
        int idx = 0;
        while(!maxHeap.isEmpty()){
            ans[idx++] = maxHeap.poll();
        }
        return ans;
    } 
}