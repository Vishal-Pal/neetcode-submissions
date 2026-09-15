class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2]; // Result array
        Arrays.fill(res, -1); // Default when no solution found
        Map<Integer, Integer> valueToIndexMap = new HashMap<>();
        for(int j=0;j<nums.length;j++){
            int currNum = nums[j];
            int reqdNum = target-nums[j];
            if(valueToIndexMap.containsKey(reqdNum)){
                int i = valueToIndexMap.get(reqdNum);
                res[0]=i;
                res[1]=j;
                break;
            }
            valueToIndexMap.put(currNum, j);
        }
        return res; // Default return - No Solution
    }
}

/**

Brute Force
Iterate the array with nested loops, outer loop ,i starting from 0, and inner loop, j starting from outer loop iterator count+1, i.e, i+1
For each i,j, check if nums[i]+nums[j] is equal to target
If it is, return the pair [i,j]
Here, since i will always be smaller than j, so the constraint that
return the answer with smaller index first is satisfied
And, if not equal, then keep iterating
While it is given that there will be exactly one solution, for no solution
I am assuming the result as [-1,-1]
Negative indices mean no suitable index found

TC - O(n^2), SC - O(1)

Extra Space Approach
target = 7
currNum = 3
reqNum = 7-3 = 4
=> reqNum - number required which when added to the currNum will give the target

Maintain a set -
Set won't do, since we'll require the first index of occurence of the element

We may use a HashMap instead => Element, Index - But only if the element is not already present

[5,5,7], 12
 ^

i = 0
valueToIndexMap - ()
(target-currNum) 12-5 = 7 => Exists in valueToIndexMap? No - Means the reqdNum is not present
(currNum) 5 => Exists in valueToIndexMap? No , Add it
valueToIndexMap - ((5,0))

i = 1
valueToIndexMap - ((5,0))
12-5 = 7 => Exists in valueToIndexMap? No - Means the reqdNum is not present
5 => Exists in valueToIndexMap? Yes , Don't add it
valueToIndexMap - ((5,0))

i = 2
valueToIndexMap - ((5,0))
12-7 = 5 => Exists in valueToIndexMap? Yes - Means the reqNum is present
- Fetch the index of the reqdNum, Add it to the 0th index of result
Add current index to 1st index of result
return result

TC - O(n), SC - O(n)

*/