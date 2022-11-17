// map, key is the number, value is a list of idx that the value at
// {1: [0,3], 2:[1], 3:[2]}
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int N =nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i< N; i++){
            List<Integer> ogList = map.getOrDefault(nums[i], new ArrayList<>());
            ogList.add(i);
            map.put(nums[i], ogList);
        }
        for(Integer key: map.keySet()){
            List<Integer> list = map.get(key);
            for(int i=1; i< list.size(); i++){
                if(list.get(i) -list.get(i-1) <=k){
                    return true;
                }
            }
        }
        return false;
    }
}