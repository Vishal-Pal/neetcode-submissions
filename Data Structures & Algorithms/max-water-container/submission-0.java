class Solution {
    public int maxArea(int[] heights) {
        int start = 0, end = heights.length-1;
        int maxAmt = Integer.MIN_VALUE;
        while(start<end){
            int minHeight = Math.min(heights[start], heights[end]);
            int waterAmt = minHeight*(end-start);
            maxAmt = Math.max(maxAmt, waterAmt);
            if(heights[start]>heights[end]){
                end--;
            } else{
                start++;
            }
        }
        return maxAmt;
    }
}
