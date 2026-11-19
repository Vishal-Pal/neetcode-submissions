class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        if(len == 1){
            return nums[0];
        }
        int[] dp = new int[len];
        dp[len-1] = nums[len-1];
        dp[len-2] = Math.max(nums[len-2], nums[len-1]);
        for(int ind=len-3;ind>=0;ind--){
            dp[ind] = Math.max(nums[ind]+dp[ind+2], dp[ind+1]);
        }
        return dp[0];
    }
}
