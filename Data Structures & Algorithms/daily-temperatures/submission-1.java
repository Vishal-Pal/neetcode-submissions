class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int [] res = new int[len];
        Deque<Pair<Integer, Integer>> stack = new ArrayDeque<>();
        for(int ind=len-1;ind>=0;ind--){
            int temperature = temperatures[ind];
            while(!stack.isEmpty() && temperature >= stack.peek().getKey()){
                stack.pop();
            }
            if(!stack.isEmpty()){
                int warmerInd = stack.peek().getValue();
                int noOfDays = warmerInd-ind;
                res[ind] = noOfDays;
            }
            stack.push(new Pair(temperature, ind));
        }
        return res;
    }
}
