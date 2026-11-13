class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] cache = new int[len];
        cache[len-1] = cost[len-1];
        cache[len-2] = cost[len-2];
        for(int ind=len-3;ind>=0;ind--){
            cache[ind] = cost[ind]+Math.min(cache[ind+1], cache[ind+2]);
        } 
        return Math.min(cache[0], cache[1]);
    }
}


/***

Input: cost = [1,2,3]

1->2->3/4 = 3
1->3->4/5 = 4

2->3->4/5 /4 = 5/ 2

minCost(0)

1+minCost(1), minCost(2)
1+

minCost(1)


                   minCost(0)
                   /           \
                  minCost(1)   minCost(2)
                  /         \
                  minCost(2) minCost(3)
                  /        \
                  minCost(3) minCost(4)

*/
