class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        int[][] posSpeed = new int[len][2];
        for(int i=0;i<len;i++){
            posSpeed[i][0] = position[i];
            posSpeed[i][1] = speed[i];
        }
        Arrays.sort(posSpeed, (a,b)->Integer.compare(b[0],a[0]));
        Deque<Double> stack = new ArrayDeque<>();
        for(int i=0;i<len;i++){
            double time = (double)(target-posSpeed[i][0])/posSpeed[i][1];
            if(stack.isEmpty() || time>stack.peek()){
                stack.push(time);
            }
        }
        return stack.size();
    }
}