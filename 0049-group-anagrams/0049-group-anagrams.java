// { "aet": ["eat"]}
// { "aet": ["eat", "tea"]}
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for(String str: strs){
            char[] chArr = str.toCharArray();
            Arrays.sort(chArr);
            String key = new String(chArr);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        List<List<String>> ans = new ArrayList<>();
        for(String k: map.keySet()){
            ans.add(map.get(k));
        }
        return ans;
    }
}