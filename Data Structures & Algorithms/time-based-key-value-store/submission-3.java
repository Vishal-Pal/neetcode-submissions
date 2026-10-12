class TimeMap {
    Map<String, List<Pair<Integer, String>>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k->new ArrayList<>()).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        String result = "";
        List<Pair<Integer, String>> values = timeMap.getOrDefault(key, Collections.emptyList());
        int start = 0, end = values.size()-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            int currTimeStamp = values.get(mid).getKey();
            if(currTimeStamp <= timestamp){
                result = values.get(mid).getValue();
                start = mid+1;
            } else{
                end = mid-1;
            }
        }
        return result;
    }
}
