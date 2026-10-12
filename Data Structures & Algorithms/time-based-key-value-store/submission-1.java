class TimeMap {
    Map<String, Map<Integer, String>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.putIfAbsent(key, new TreeMap<>());
        timeMap.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        Map<Integer, String> values = timeMap.get(key);
        if(values == null || values.isEmpty()){
            return "";
        }
        String result = "";
        int start = 0, end = values.size()-1;
        List<Integer> timestamps = new ArrayList<>(values.keySet());
        while(start<=end){
            int mid = start + (end-start)/2;
            int currTimeStamp = timestamps.get(mid);
            if(currTimeStamp == timestamp){
                result = values.get(currTimeStamp);
                break;
            } else if(currTimeStamp < timestamp){
                result = values.get(currTimeStamp);
                start = mid+1;
            } else{
                end = mid-1;
            }
        }
        return result;
    }
}
