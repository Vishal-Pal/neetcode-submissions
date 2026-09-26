class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int [] res = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int ind=len-1;ind>=0;ind--){
            int temperature = temperatures[ind];
            while(!stack.isEmpty() && temperature >= temperatures[stack.peek()]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                int warmerInd = stack.peek();
                int noOfDays = warmerInd-ind;
                res[ind] = noOfDays;
            }
            stack.push(ind);
        }
        return res;
    }
}
