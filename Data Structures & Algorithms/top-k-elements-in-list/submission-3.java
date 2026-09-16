class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Form frequency map
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num:nums){
            freqMap.merge(num, 1, Integer::sum);
        }
        
        Map<Integer, List<Integer>> freqBucket = new HashMap<>();
        for(int num:freqMap.keySet()){
            int freq = freqMap.get(num);
            freqBucket.putIfAbsent(freq, new ArrayList<>());
            freqBucket.get(freq).add(num);
        }

        // Form the result
        int[] res = new int[k];
        int ind = 0;
        for(int freq=nums.length;freq>=0 && ind<k;freq--){
            if(!freqBucket.containsKey(freq)){
                continue;
            }
            List<Integer> freqList = freqBucket.get(freq);
            for(int num:freqList){
                res[ind++] = num; // All unique numbers with same frequency shall be added
            }
        }
        return res;
    }
}
