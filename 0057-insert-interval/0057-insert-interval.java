// solved by 3 while loop (3 phases).
// 1. add the interval which is not overllaped with the new interval to the answer list
// 2. merge the largest range's interval if the curr interval is overlapped with new interval
//     * insert the new interval here
// 3. add the rest of the intervals to the answer list
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int N = intervals.length;
        int idx = 0;
        while(idx < N && newInterval[0] > intervals[idx][1]){
            list.add(intervals[idx]);
            idx++;
        }
        // merge
        while(idx < N && intervals[idx][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[idx][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[idx][1], newInterval[1]);
            idx++;
        }
        list.add(newInterval);
        while(idx < N){
            list.add(intervals[idx]);
            idx++;
        }        
        int[][] ans = new int[list.size()][2];
        for(int i=0; i< list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}