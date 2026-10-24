class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length-1;
        int min = Integer.MAX_VALUE;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]<=nums[end]){
                min = Math.min(min, nums[mid]);
                end = mid-1;
            } else{
                start = mid+1;
            }
        }
        return min;
    }
}


/**

 0 1 2 3 4 5
[3,4,5,6,1,2]
 ^   ^ ^   ^


Need to decide which element to compare against which to decide which half is sorted

minimum

Find the first element in the sorted half

 0 1 2 3 4 5
[1,2,3,4,5,6]
     ^

     nums[mid]<nums[end]
     2nd half is sorted => mid will be the lowest in the second half - so no need to search the second half for lower value
     nums[mid]>nums[end]
     A number lower than mid exists in the second half, so search that => start = mid+1
**/
