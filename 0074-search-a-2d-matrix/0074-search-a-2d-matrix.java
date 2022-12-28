class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int cLen = matrix[0].length;
        for(int[] row: matrix){
            if(row[0] <= target && target <= row[cLen-1]){
                int l = 0;
                int r = cLen - 1;
                while(l <= r){
                    int mid = l + (r - l)/2;
                    if(row[mid] == target){
                        return true;
                    }else if(row[mid] <= target){
                        l = mid + 1;
                    }else{
                        r = mid - 1;
                    }
                }
            }
        }
        return false;
    }
}

// TC: O(NlogN)
// SC: O(1)