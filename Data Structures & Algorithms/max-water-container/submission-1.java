class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int start = 0, end = heights.length-1;
        while(start<end){
            int startHeight = heights[start];
            int endHeight = heights[end];
            if(startHeight<=endHeight){
                maxArea = Math.max(maxArea, startHeight*(end-start));
                start++;
            } else{
                maxArea = Math.max(maxArea, endHeight*(end-start));
                end--;                
            }
        }
        return maxArea;
    }
}
