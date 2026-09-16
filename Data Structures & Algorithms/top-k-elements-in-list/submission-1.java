class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num:nums){
            // merge method arguments
            // (key, value, remappingFunction)
            // key - the key to be operated upon
            // value - default value to be inserted if key isn't present in map
            // Remapping Function - A bifunction taking 2 arguments only
            // (oldValue, value) where oldValue is the value already present in map for the key
            // Note that remapping function is only used
            // when the key is present in the map
            // otherwise, the value is inserted in it
            freqMap.merge(num, 1, Integer::sum);
        }

        int[] res = freqMap
        .entrySet()
        .stream()
        .sorted((e1,e2)->e2.getValue().compareTo(e1.getValue()))
        .limit(k)
        .mapToInt(Map.Entry::getKey)
        .toArray()
        ;
        return res;
    }
}
