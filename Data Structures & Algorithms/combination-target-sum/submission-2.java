class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        combinationSum(nums, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void combinationSum(int[] nums, int target, int ind, List<Integer> currNums, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(currNums));
            return;
        }
        for(int j=ind;j<nums.length;j++){
            if(target<nums[j]){
                return;
            }
            currNums.add(nums[j]);
            combinationSum(nums, target-nums[j], j, currNums, res);
            currNums.remove(currNums.size()-1);
        }
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
