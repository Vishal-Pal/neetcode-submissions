class TimeMap {
    Map<String, List<Pair<Integer, String>>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.putIfAbsent(key, new ArrayList<>());
        timeMap.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> values = timeMap.get(key);
        if(values == null || values.isEmpty()){
            return "";
        }
        String result = "";
        int start = 0, end = values.size()-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            int currTimeStamp = values.get(mid).getKey();
            if(currTimeStamp == timestamp){
                result = values.get(mid).getValue();
                break;
            } else if(currTimeStamp < timestamp){
                result = values.get(mid).getValue();
                start = mid+1;
            } else{
                end = mid-1;
            }
        }
        return result;
    }
}
