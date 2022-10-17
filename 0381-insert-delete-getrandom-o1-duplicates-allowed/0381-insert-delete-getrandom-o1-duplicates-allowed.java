class RandomizedCollection {
    Map<Integer, Set<Integer>> map;
    List<Integer> list;
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            map.put(val, new HashSet<>());
        }
        
        map.get(val).add(list.size());
        list.add(val);
        return map.get(val).size()==1 ;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val) || map.get(val).size()==0 ){
            return false;
        }       
        int removedIdx = map.get(val).iterator().next();
        map.get(val).remove(removedIdx);
        
        int lastEle = list.get(list.size()-1);
        list.set(removedIdx, lastEle);
        map.get(lastEle).add(removedIdx);
        map.get(lastEle).remove(list.size()-1);

        
        list.remove(list.size()-1);
        
        return true;
    }
    
    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */