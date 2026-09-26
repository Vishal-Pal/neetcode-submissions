class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int [] res = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int curr=0;curr<len;curr++){
            int temperature = temperatures[curr];
            while(!stack.isEmpty() && temperature > temperatures[stack.peek()]){
                int prev = stack.pop();
                int noOfDays = curr-prev;
                res[prev] = noOfDays;
            }
            stack.push(curr);
        }
        return res;
    }
}
