// sort by start
// if any element's end larger than lastStart, than we know there is an overlap
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (e1, e2) -> Integer.compare(e1[0], e2[0]));
        int N= intervals.length;
        int lastStart= intervals[N-1][0];
        int overlap= 0;
        for(int i=N-2; i>=0; i--){
            if(intervals[i][1] > lastStart){
                overlap++;
            }else{
                lastStart= intervals[i][0];
            }
        }
        return overlap;
    }
}