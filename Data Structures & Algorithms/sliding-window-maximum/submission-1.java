class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        for(int i=0;i<k;i++){
            pq.offer(nums[i]);
        }
        List<Integer> maxList = new ArrayList<>();
        maxList.add(pq.peek());
        int len = nums.length;
        for(int i=k;i<len;i++){
            pq.remove(nums[i-k]);
            pq.offer(nums[i]);
            maxList.add(pq.peek());
        }
        return maxList.stream().mapToInt(Integer::intValue).toArray();
    }
}
