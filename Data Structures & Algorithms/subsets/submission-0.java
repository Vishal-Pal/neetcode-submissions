class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, 0);
    }

    private List<List<Integer>> subsets(int[] nums, int start){
        if(start>=nums.length){
            List<Integer> emptyList = new ArrayList<>();
            List<List<Integer>> res = new ArrayList<>();
            res.add(emptyList);
            return res;
        }
        List<List<Integer>> res = new ArrayList<>();
        int numStart = nums[start];
        List<List<Integer>> subRes = subsets(nums, start+1);
        for(List<Integer> subList:subRes){
            res.add(subList);
            List<Integer> subListIncludingCurr = new ArrayList<>();
            subListIncludingCurr.add(numStart);
            subListIncludingCurr.addAll(subList);
            res.add(subListIncludingCurr);
        }
        return res;
    }
}

/***

To create a subset
we have 2 choices-
Either include this element
Or don't include this element


[1,2,3]

start , end => Signify which part of the nums array I am dealing with right

if(start>end){

return empty list
}
 0 1 2
[1,2,3]
 ^

 (0,2)

 1

 ()
 []
 [2]
 [3]
 [2,3]
 [1]
 [1,2]
 [1,3]
 [1,2,3]


[1]

start = end

[]
[1]


*/