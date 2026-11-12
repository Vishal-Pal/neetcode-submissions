class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int ind, List<Integer> currList, List<List<Integer>> res){
        int len = nums.length;
        if(ind==len){
            res.add(new ArrayList<>(currList));
            return;
        }
        currList.add(nums[ind]);
        dfs(nums, ind+1, currList, res);
        currList.remove(currList.size()-1);
        ind++;
        while(ind<len && nums[ind]==nums[ind-1]){
            ind++;
        }
        dfs(nums, ind, currList, res);
    }
}


/***

[1,2,1]

I am thinking of sorting the array to skip duplicates

How so?
[1,1,2]
 ^

dfs(0,())

dfs(1,()) and dfs(1,(1))



[1,2]
 ^     
res = [[]]

end = 1
0
[][2]


0  1   2  3
[][2]
[][2],[1][2,1]
[][2],[1][2,1],[1,1][2,1,1]



[1,1]

[][1]
[][1][1,1]
*/
