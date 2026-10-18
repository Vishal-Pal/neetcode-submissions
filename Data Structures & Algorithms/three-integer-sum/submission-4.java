class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> threeSumSet = new HashSet<>();
        int len = nums.length;
        Arrays.sort(nums);
        for(int ind=0;ind<len;ind++){
            if(nums[ind]>0){
                break;
            }
            int start = ind+1, end = len-1;
            while(start<end){
                int sum = nums[ind]+nums[start]+nums[end];
                if(sum == 0){
                    threeSumSet.add(Arrays.stream(new int[]{nums[ind], nums[start], nums[end]}).boxed().collect(Collectors.toList()));
                    start++;
                } else if(sum>0){
                    end--;
                } else{
                    start++;
                }
            }
        }
        return new ArrayList<>(threeSumSet);    
    }
}
