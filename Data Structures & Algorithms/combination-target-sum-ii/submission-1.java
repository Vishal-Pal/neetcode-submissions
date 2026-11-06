class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>(), res);        
        return res;
    }

    private void dfs(int[] candidates, int target, int ind, List<Integer> currSum, List<List<Integer>> res){
        if(target == 0){ // sum found
            res.add(new ArrayList<>(currSum));
            return;
        }
        for(int curr=ind;curr<candidates.length;curr++){
            int candidate = candidates[curr];
            if(candidate>target){
                break;
            }
            if(curr!=ind && candidate==candidates[curr-1]){
                continue;
            }
            currSum.add(candidate);
            dfs(candidates, target-candidate, curr+1, currSum, res);
            currSum.remove(currSum.size()-1);
        }
    }
}

/**


dfs(target-nums[ind],ind+1)
dfs(target, ind+1)

*/
