class Solution {
    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        List<Integer> sub = new ArrayList<>();

        // build the longest and optimal subsequence
        for(int i=0; i< N; i++){
            int curr = nums[i];
            if(sub.size()==0 || curr > sub.get(sub.size()-1)){
                sub.add(curr);
                continue;
            }
            for(int j=0; j< sub.size(); j++){// j is the index of poosible to be replaced
                if(sub.get(j) >= curr){
                    sub.set(j, curr);
                    break;
                }
            }
        }
        // System.out.println(sub);
        return sub.size();
    }
}

// TC: O(N^2)
// SC: O(N)