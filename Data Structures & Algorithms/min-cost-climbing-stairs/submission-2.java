class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int next = cost[len-1];
        int curr = cost[len-2];
        for(int ind=len-3;ind>=0;ind--){
            int temp = curr;
            curr = cost[ind]+Math.min(curr, next);
            next = temp;
        } 
        return Math.min(curr, next);
    }
}


/***

Input: cost = [1,1,2,3]

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
