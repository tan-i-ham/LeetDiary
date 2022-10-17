class RandomizedSet {
    int idx;
    Map<Integer, Integer> map;
    List<Integer> list;
    public RandomizedSet() {
        idx = 0;
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val, idx++);
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int currIdx = map.get(val);
            int lastEle = list.get(idx-1);
            list.set(currIdx, lastEle);
            map.put(lastEle, currIdx);
            map.remove(val);
            list.remove(idx-1);
            idx--;
            return true;
        }

        return false;        
    }
    
    public int getRandom() {
        int i = new Random().nextInt(list.size());
        return list.get(i);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */