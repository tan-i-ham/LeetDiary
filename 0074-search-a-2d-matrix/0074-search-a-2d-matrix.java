class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rLen = matrix.length;
        int cLen = matrix[0].length;
        
        int l = 0;
        int r = rLen * cLen - 1;
        while(l <= r){
            int pivotIdx = l + (r - l)/2;
            int pivotEle = matrix[pivotIdx/cLen][pivotIdx%cLen];
            if(pivotEle == target){
                return true;
            }
            if(pivotEle < target){
                l = pivotIdx + 1;
            }else{
                r = pivotIdx - 1;
            }
        }
        return false;
    }
}

// TC: O(MlogN), M is the row length
// SC: O(1)