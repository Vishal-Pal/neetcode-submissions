class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num:nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }
        Map<Integer, List<Integer>> freqBucket = new HashMap<>();
        for(int num:freqMap.keySet()){
            int freq = freqMap.get(num);
            freqBucket.putIfAbsent(freq, new ArrayList<>());
            freqBucket.get(freq).add(num);
        }
        int[] res = new int[k];
        int ind = 0;
        for(int freq=nums.length;freq>=0&&ind<k;freq--){
            if(!freqBucket.containsKey(freq)){
                continue;
            }
            List<Integer> freqNums = freqBucket.get(freq);
            for(int num:freqNums){
                res[ind++]=num;
                if(ind==k){
                    return res;
                }
            }
        }
        return res;
    }
}
