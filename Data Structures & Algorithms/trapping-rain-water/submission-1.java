class Solution {
    public int trap(int[] height) {
        int area = 0;
        int len = height.length;
        int leftMax = height[0];
        int rightMax = height[len-1];
        int start = 0, end = len-1;
        while(start<end){
            if(leftMax<rightMax){
                start++;
                leftMax = Math.max(leftMax, height[start]);
                area+=leftMax-height[start];
            } else{
                end--;
                rightMax = Math.max(rightMax, height[end]);
                area+=rightMax-height[end];
            }
        }
        return area;
    }
}
