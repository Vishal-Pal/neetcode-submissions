class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int [] res = new int[len];
        for(int curr=len-2;curr>=0;curr--){
            int temperature = temperatures[curr];
            int next = curr+1;
            while(next<len && temperature >= temperatures[next]){
                if(res[next]==0){
                    next = len; // No warmer index exists
                    break;
                }
                next+=res[next];
            }
            if(next<len){
                res[curr] = next-curr;
            }
        }
        return res;
    }
}
