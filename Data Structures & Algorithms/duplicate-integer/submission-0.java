class Solution {
    public boolean hasDuplicate(int[] nums) {
        int len = nums.length;
        if(len<=1){ // No/ Single Element
            return false;
        }
        Set<Integer> numSet = new HashSet<>();
        for(int num:nums){
            if(numSet.contains(num)){
                return true;
            }
            numSet.add(num);
        }
        return false;
    }
}

/***

Brute Force -
Iterate the array in an outer loop from 0 and an inner loop from 1
Then compare the elements if any matching
return true if matched

TC - O(n^2), SC - O(1)

If extra space is allowed, then I'll use a set
Iterate the array, check whether element is present in set, if yes, return true
Otherwise, add it to set, return false at the end of the iteration

TC - O(n), SC - O(n)



*/