class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num:nums){
            freqMap.merge(num, 1, Integer::sum);
        }
        Queue<Integer> minHeap = new PriorityQueue<>(
            (num1, num2)->freqMap.get(num1)-freqMap.get(num2)
        );
        for(int num:freqMap.keySet()){
            minHeap.offer(num);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        int[] res = new int[k];
        for(int ind=0;ind<k;ind++){
            res[ind]=minHeap.poll();
        }
        return res;
    }
}
