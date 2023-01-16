// when to merge? prev[1] (end) >= curr[0] (start)
// 1. sort ascendingly 
// 2. compare previous end and current start
// 3. if not merge, then add to list
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int[] prev = intervals[0];
        for(int i=1; i< intervals.length; i++){
            int[] curr = intervals[i];
            if(prev[1] >= curr[0]){
                prev[0] = Math.min(prev[0], curr[0]);
                prev[1] = Math.max(prev[1], curr[1]);
            }else{
                list.add(prev);
                prev = curr;
            }
        }
        list.add(prev);
        int[][] ans = new int[list.size()][2];
        int idx=0;
        for(int[] ele: list){
            ans[idx++] = ele;
        }
        return ans;
    }
}