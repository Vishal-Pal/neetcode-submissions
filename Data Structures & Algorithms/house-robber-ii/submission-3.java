class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        return Math.max(rob(nums, 0, len-2), rob(nums, 1, len-1));
    }

    public int rob(int[] nums, int start, int end) {
        int prev = 0, curr = 0;
        for(int ind=start;ind<=end;ind++){
            int temp = curr;
            curr = Math.max(nums[ind]+prev, curr);
            prev = temp;
        }
        return curr;
    }
}