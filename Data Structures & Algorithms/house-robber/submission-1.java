class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        if(len == 1){
            return nums[0];
        }
        int next = nums[len-1];
        int curr = Math.max(nums[len-2], nums[len-1]);
        for(int ind=len-3;ind>=0;ind--){
            int temp = curr;
            curr = Math.max(nums[ind]+next, curr);
            next = temp;
        }
        return curr;
    }
}
