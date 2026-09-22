class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length-1;
        while(start<end){
            int sum = numbers[start]+numbers[end];
            if(sum == target){
                int [] res = new int[2];
                res[0]=start+1;
                res[1]=end+1;
                return res;
            } else if(sum<target){
                start++;
            } else{
                end--;
            }
        }
        return new int[]{-1,-1};
    }
}
