class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int start = 0, end = nums.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            // Left Half Sorted
            if(nums[start]<=nums[mid]){
                min = Math.min(min, nums[start]);
                start = mid+1;
            } else{ // Right Half Sorted
                min = Math.min(min, nums[mid]);
                end = mid-1;
            }
        }
        return min;
    }
}
