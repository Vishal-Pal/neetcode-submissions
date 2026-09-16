class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num:nums){
            int freq = freqMap.getOrDefault(num, 0)+1;
            freqMap.put(num, freq);
        }
    Map<Integer, Integer> sortedDesc = freqMap.entrySet()
        .stream()
        .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        int[] res = new int[k];
        int index = 0;
        for(int val:sortedDesc.keySet()){
            res[index++]=val;
            if(index==k){
                break;
            }
        }
        return res;
    }
}
