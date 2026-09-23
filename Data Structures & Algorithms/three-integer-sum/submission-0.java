class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    
        Set<List<Integer>> threeSumListSet = new HashSet<>();

        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);

        int end = nums.length-1;
        for(int ind=0;ind<=end;ind++){
            int num = sortedNums[ind];
            int target = -1*num;
            List<List<Integer>> twoSumLists = twoSum(sortedNums, target, ind+1, end);
            if(twoSumLists.isEmpty()){
                continue;
            }
            for(List<Integer> twoSumList:twoSumLists){
                twoSumList.add(num);
                threeSumListSet.add(twoSumList);
            }
        }

        return new ArrayList<>(threeSumListSet);

    }

    private List<List<Integer>> twoSum(int[] nums, int target, int start, int end){
        List<List<Integer>> twoSumLists = new ArrayList<>();
        if(start>end){
            return twoSumLists;
        }
        while(start<end){
            int startNum = nums[start];
            int endNum = nums[end];
            int sum = startNum+endNum;
            if(sum == target){
                List<Integer> twoSumList = new ArrayList<>();
                twoSumList.add(startNum);
                twoSumList.add(endNum);
                twoSumLists.add(twoSumList);
                start++;
            } else if(sum<target){
                start++;
            } else{
                end--;
            }
        }
        return twoSumLists;
    }
}
