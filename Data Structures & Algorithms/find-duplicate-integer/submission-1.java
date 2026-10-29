class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow!=fast);
        int slow2 = 0;
        do{
            slow = nums[slow];
            slow2 = nums[slow2];
        } while(slow!=slow2);
        return slow;
    }
}



/***
        0 1 2 3 4
nums = [1,2,3,2,2]


0->1->2->3
      ^  |
      |__|
       
*/