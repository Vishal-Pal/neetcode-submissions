class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int mask, List<Integer> currList, List<List<Integer>> res){
        int len = nums.length;
        if(currList.size()==len){
            res.add(new ArrayList<>(currList));
            return;
        }
        for(int ind=0;ind<len;ind++){
            if((mask & (1<<ind))!=0){
                continue;
            }
            currList.add(nums[ind]);
            backtrack(nums,mask|(1<<ind),currList,res);
            currList.remove(currList.size()-1);
        }
    }
}
