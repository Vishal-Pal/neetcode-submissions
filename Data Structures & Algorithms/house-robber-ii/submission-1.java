class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][2];
        for(int ind=0;ind<len;ind++){
            int[] arr = {-1, -1};
            dp[ind] = arr;
        }
        return Math.max(nums[0]+rob(nums, 2, 1, dp), rob(nums, 1, 0,dp));
    }

    public int rob(int[] nums, int ind, int firstIncluded, int[][] dp) {
        int len = nums.length;
        if(ind>=len || (firstIncluded==1 && ind==len-1)){
            return 0;
        }
        if(dp[ind][firstIncluded]!=-1){
            return dp[ind][firstIncluded];
        }
        return dp[ind][firstIncluded] = Math.max(nums[ind]+rob(nums,ind+2, firstIncluded,dp), rob(nums,ind+1, firstIncluded,dp));
    }
}