class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        boolean[] visited = new boolean[len];
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, visited, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, boolean[] visited, List<Integer> currList, List<List<Integer>> res){
        int len = nums.length;
        if(currList.size()==len){
            res.add(new ArrayList<>(currList));
            return;
        }
        for(int ind=0;ind<len;ind++){
            if(visited[ind]){
                continue;
            }
            visited[ind]=true;
            currList.add(nums[ind]);
            backtrack(nums,visited,currList,res);
            currList.remove(currList.size()-1);
            visited[ind]=false;
        }
    }
}
