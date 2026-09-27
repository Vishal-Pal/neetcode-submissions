class Solution {
    public int trap(int[] height) {
        int area = 0;
        int len = height.length;
        int[] maxBeforeCurr = new int[len];
        int[] maxAfterCurr = new int[len];
        maxBeforeCurr[0] = height[0];
        for(int i=1;i<len;i++){
            maxBeforeCurr[i] = Math.max(maxBeforeCurr[i-1], height[i]);
        }
        maxAfterCurr[len-1] = height[len-1];
        for(int i=len-2;i>=0;i--){
            maxAfterCurr[i] = Math.max(maxAfterCurr[i+1], height[i]);
        }
        for(int i=0;i<len;i++){
            if(maxBeforeCurr[i] == 0 || maxAfterCurr[i] == 0){
                continue;
            }
            area+=Math.min(maxBeforeCurr[i], maxAfterCurr[i])-height[i];
        }
        return area;
    }
}
