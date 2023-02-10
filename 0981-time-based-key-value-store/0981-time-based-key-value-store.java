class TimeMap {
    Map<String, List<Integer>> timeByKey;
    Map<String, List<String>> valueByKey;
    public TimeMap() {
        timeByKey = new HashMap<>();
        valueByKey = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Integer> tList = timeByKey.getOrDefault(key, new ArrayList<>());
        tList.add(timestamp);
        timeByKey.put(key, tList);
            
        List<String> vList = valueByKey.getOrDefault(key, new ArrayList<>());
        vList.add(value);
        valueByKey.put(key, vList);
    }
    
    public String get(String key, int timestamp) {
        List<Integer> tList = timeByKey.getOrDefault(key, new ArrayList<>());
        int size = tList.size();
        if(size==0){
            return "";
        }
        
        if(timestamp >= tList.get(size-1) ){
            return valueByKey.get(key).get(size-1);
        }
        int l = 0;
        int r = size - 1;
        while(l <= r){
            int m = l + (r-l)/2;
            if(tList.get(m) == timestamp){
                return valueByKey.get(key).get(m);
            }
            if(tList.get(m) < timestamp){
                l = m + 1;
            }else{
                r = m - 1;
            }
        }

        if(timeByKey.get(key).get(l) > timestamp){
            if(l > 0 ){
                return valueByKey.get(key).get(l-1);    
            }
            return "";
        }

        return valueByKey.get(key).get(l);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */