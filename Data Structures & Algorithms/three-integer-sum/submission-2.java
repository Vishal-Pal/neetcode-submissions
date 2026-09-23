class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    
        List<List<Integer>> threeSumLists = new ArrayList<>();

        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);

        int len = nums.length;
        for(int ind=0;ind<len;ind++){
            if(sortedNums[ind]>0){
                break;
            }
            while(ind>0 && ind<len && sortedNums[ind]==sortedNums[ind-1]){
                ind++;
            }
            if(ind==len){
                break;
            }
            int num = sortedNums[ind];
            int start = ind+1, end = len-1;
            while(start<end){
                int startNum = sortedNums[start];
                int endNum = sortedNums[end];
                int sum = num+startNum+endNum;
                if(sum == 0){
                    threeSumLists.add(Arrays.asList(num, startNum, endNum));
                    start++;
                    end--;
                    while(start<end && sortedNums[start]==sortedNums[start-1]){
                        start++;
                    }
                } else if(sum<0){
                    start++;
                } else{
                    end--;
                }
            }
        }

        return threeSumLists;

    }
}
