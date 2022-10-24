// sort the intervals array by start
// create a var called toBeAdd to keep an interval to add into the ans
// start loop by each element
// if new interval start is smaller ans equal than the current element, try to merge
//      set to the toBeAdd
// when to add newInterval to the ans
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