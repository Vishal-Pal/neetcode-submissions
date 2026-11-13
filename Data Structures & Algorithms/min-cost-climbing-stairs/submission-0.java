class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] cache = new int[cost.length];
        Arrays.fill(cache, -1);
        return Math.min(minCost(cost, 0, cache), minCost(cost, 1, cache));
    }


    private int minCost(int[] cost, int ind, int[] cache){
        if(ind>=cost.length){
            return 0;
        }
        if(cache[ind]!=-1){
            return cache[ind];
        }
        return cache[ind] = cost[ind]+Math.min(minCost(cost, ind+1, cache), minCost(cost, ind+2, cache));
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
