class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len-k+1];
        int start = 0;
        Deque<Integer> dq = new LinkedList<>();
        for(int end=0;end<len;end++){
            // Remove smaller elements from deque end
            while(!dq.isEmpty() && nums[dq.getLast()]<nums[end]){
                dq.removeLast();
            }
            // Add current index to deque end
            dq.addLast(end);
            // If the first index in deque is out of current window, remove it
            if(dq.getFirst()<start){
                dq.removeFirst();
            }
            // If window size is k, update result
            if(end+1>=k){
                res[start++]=nums[dq.getFirst()];
            }
        }
        return res;
    }
}
