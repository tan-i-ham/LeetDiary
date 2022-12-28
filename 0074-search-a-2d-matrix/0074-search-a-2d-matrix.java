class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int N = matrix.length * matrix[0].length;
        int[] arr = new int[N];
        int i=0;
        for(int[] m: matrix){
            for(int ele: m){
                arr[i++] = ele;
            }
        }
        int l = 0;
        int r = N-1;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(arr[mid] == target){
                return true;
            }else if(arr[mid] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return false;
    }
}