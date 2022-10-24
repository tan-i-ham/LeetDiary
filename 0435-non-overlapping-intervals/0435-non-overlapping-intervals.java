// toBeAdd is the array that we want to add to the list
// for loop, if two interval can merge, update the toBeAdd
// the update logic, choose min for both start and end
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (e1, e2) -> Integer.compare(e1[0], e2[0]));
        List<int[]> list = new ArrayList<>();
        int[] toBeAdd = intervals[0];
        for(int i=1; i< intervals.length; i++){
            if(intervals[i][0] >= toBeAdd[1]){
                // System.out.println(Arrays.toString(toBeAdd));
                list.add(toBeAdd);
                toBeAdd = intervals[i];
            }else{
                toBeAdd[0] = Math.min(toBeAdd[0], intervals[i][0]);
                toBeAdd[1] = Math.min(toBeAdd[1], intervals[i][1]);
            }
        }
        list.add(toBeAdd);
        return intervals.length - list.size();
    }
}