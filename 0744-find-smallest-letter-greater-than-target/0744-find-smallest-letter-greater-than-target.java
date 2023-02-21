class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int N = letters.length;
        int l = 0;
        int r = N - 1;
        if(letters[r] <= target){
            return letters[0];
        }
        while(l < r){
            int mid = l + (r - l)/2;
            if(target < letters[mid]){
                r = mid;
            }else if(target >= letters[mid]){
                l = mid + 1;
            }
        }
        return letters[l];
    }
}