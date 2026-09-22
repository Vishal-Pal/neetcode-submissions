class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int end = numbers.length-1;
        for(int ind=0;ind<numbers.length;ind++){
            int reqdNum = target-numbers[ind];
            int reqdNumInd = binarySearch(numbers, reqdNum);
            if(reqdNumInd!=-1 && reqdNumInd!=ind){
                int[] res = new int[2];
                res[0] = Math.min(ind,reqdNumInd)+1;
                res[1] = Math.max(ind,reqdNumInd)+1;
                return res;
            }
        }
        return new int[0];
    }

    private int binarySearch(int[] numbers, int target){
        int start = 0, end = numbers.length-1;
        while(start<end){
            int mid = (start+end)/2;
            if(numbers[mid] == target){
                return mid;
            } else if(numbers[mid]<target){
                start=mid+1;
            } else{
                end=mid;
            }
        }
        return -1;
    }
}
