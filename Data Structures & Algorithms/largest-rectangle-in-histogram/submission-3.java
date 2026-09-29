class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int len = heights.length;
        // Find next smaller element to the left
        // Find next smaller element to the right
        int[] nextSmallerLeft = new int[len];
        int[] nextSmallerRight = new int[len];
        for(int ind=0;ind<len;ind++){
            nextSmallerLeft[ind]=-1;
            nextSmallerRight[ind]=len;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for(int ind=0;ind<len;ind++){
            int height = heights[ind];
            while(!stack.isEmpty() && height<heights[stack.peek()]){
                int prev = stack.pop();
                nextSmallerRight[prev]=ind;
            }
            stack.push(ind);
        }
        stack.clear();
        for(int ind=len-1;ind>=0;ind--){
            int height = heights[ind];
            while(!stack.isEmpty() && height<heights[stack.peek()]){
                int next = stack.pop();
                nextSmallerLeft[next]=ind;
            }
            stack.push(ind);
        }
        for(int ind = 0;ind<len;ind++){
            int height = heights[ind];
            int leftBound = nextSmallerLeft[ind]+1;
            int rightBound = nextSmallerRight[ind]-1;
            maxArea = Math.max(maxArea, (rightBound-leftBound+1)*height);
        }
        return maxArea;
    }
}