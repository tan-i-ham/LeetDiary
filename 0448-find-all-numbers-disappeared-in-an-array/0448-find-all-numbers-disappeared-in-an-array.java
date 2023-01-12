// intuitively: use Set, but space complexity will be O(N)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans =  new ArrayList<>();
        int N = nums.length;
        for(int i=1; i<= N; i++){
            int n = nums[i-1];
            while(nums[n-1] != n){
                int curr = n; // curr=4
                int next = nums[curr-1]; // next=7
                nums[curr-1] = curr; // nums[3] = 4
                n = next; // n = 7
                // System.out.println(Arrays.toString(nums));
            }
        }
        // System.out.println(Arrays.toString(nums));
        for(int i=1; i<= N; i++){
            if(nums[i-1] != i){
                ans.add(i);
            }
        }
        return ans;
    }
}

// [4,3,2,7,8,2,3,1]

// [4,3,2,4,8,2,7,1]

// [4,3,3,4,8,2,7,1]

// [4,2,3,4,8,2,7,1] nums[i-1] = i then stop, n=3

// [4,2,3,4,8,2,7,8]

// [1,2,3,4,8,2,7,8] nums[i-1] = i then stop, n=4