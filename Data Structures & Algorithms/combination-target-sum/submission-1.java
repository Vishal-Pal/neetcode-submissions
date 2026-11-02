class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currNums = new ArrayList<>();
        combinationSum(nums, target, 0, currNums, res);
        return res;
    }

    private void combinationSum(int[] nums, int target, int ind, List<Integer> currNums, List<List<Integer>> res){
        if(target<0 || ind>=nums.length){
            return; // Invalid case
        }
        if(target == 0){
            res.add(new ArrayList<>(currNums));
            return;
        }
        // Include this number
        currNums.add(nums[ind]);
        combinationSum(nums, target-nums[ind], ind, currNums, res);
        // Exclude this number
        currNums.remove(currNums.size()-1);
        combinationSum(nums, target, ind+1, currNums, res);
    }
}

/***

All num in nums are in range of [2,30]
That means all numbers are positive


target = 0
-> Current result holds all the numbers such that there sum is 0

target < 0
=> No solution here
Why? Because all the elements are positive
So, we have exceeded the target sum

=> ind
Include that index -> combinationSum(target-nums[ind], ind)
Exclude that index -> combination(target, ind+1)


nums = [2,5,6,9]
target = 9

(9,0,(),()) - (7,0,(2),())
   |
(9,1,(),()) - (4,1,(5),())
   |
(9,2,(),()) - (())



*/
