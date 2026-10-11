class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int curr=0;curr<len;curr++){
            while(!stack.isEmpty() && temperatures[curr]>temperatures[stack.peek()]){
                int prev = stack.pop();
                res[prev]=curr-prev;
            }
            stack.push(curr);
        }
        return res;
    }
}
