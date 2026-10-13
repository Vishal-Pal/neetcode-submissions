class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<int[]> pq = new PriorityQueue<>((a,b)->a[0]==b[0]?a[1]-b[1]:b[0]-a[0]);
        for(int i=0;i<k;i++){
            pq.offer(new int[]{nums[i], i});
        }
        List<Integer> maxList = new ArrayList<>();
        maxList.add(pq.peek()[0]);
        int len = nums.length;
        for(int end=k;end<len;end++){
            int start = end-k+1;
            while(!pq.isEmpty() && pq.peek()[1]<start){
                pq.poll();
            }
            pq.offer(new int[]{nums[end], end});
            maxList.add(pq.peek()[0]);
        }
        return maxList.stream().mapToInt(Integer::intValue).toArray();
    }
}
