class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));
        if(intervals.length ==0){
            return true;
        }
        int prevEnd = intervals[0][1];
        for(int i=1; i< intervals.length; i++){
            if(intervals[i][0] < prevEnd){
                return false;
            }
            // prev meeting is end
            prevEnd = intervals[i][1];
        }
        return true;
    }
}