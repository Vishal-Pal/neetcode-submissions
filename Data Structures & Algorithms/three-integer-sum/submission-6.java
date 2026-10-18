class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> threeSumList = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for(int ind=0;ind<len;ind++){
            if(nums[ind]>0){
                break;
            }
            while(ind>0 && ind<len && nums[ind]==nums[ind-1]){
                ind++;
            }
            int start = ind+1, end = len-1;
            while(start<end){
                int sum = nums[ind]+nums[start]+nums[end];
                if(sum == 0){
                    threeSumList.add(Arrays.stream(new int[]{nums[ind], nums[start], nums[end]}).boxed().collect(Collectors.toList()));
                    start++;
                    while(start<end && nums[start]==nums[start-1]){
                        start++;
                    }
                } else if(sum>0){
                    end--;
                } else{
                    start++;
                }
            }
        }
        return threeSumList;    
    }
}


/***


[-4,-1,-1,0,1,2]
     ^    ^   ^  



*/
