class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int N = intervals.length;
        
        PriorityQueue<Integer> endTimeMinHeap = new PriorityQueue<>();
        endTimeMinHeap.add(intervals[0][1]); // [30]
        for(int i=1; i< N; i++){
            int startTime = intervals[i][0];
            int endTime = intervals[i][1];
            if(startTime >= endTimeMinHeap.peek()){ // a meeting ended before the current startTime, so we can take this meeting room, we don't have to occupy another room
                endTimeMinHeap.poll(); //  [30]
            }
            endTimeMinHeap.offer(endTime); //[10,30] -> [15,30]
        }
        return endTimeMinHeap.size();
    }
}
// TC: O(NlogN)