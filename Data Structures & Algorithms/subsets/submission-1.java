class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int num:nums){
            int size = res.size();
            for(int i=0;i<size;i++){
                List<Integer> subset = new ArrayList<>(res.get(i));
                subset.add(num);
                res.add(subset);
            }
        }
        return res;
    }
}

/***

To create a subset
we have 2 choices-
Either include this element
Or don't include this element


[1,2,3]

start , end => Signify which part of the nums array I am dealing with right

if(start>end){

return empty list
}
 0 1 2
[1,2,3]
 ^

 (0,2)

 1

 ()
 []
 [2]
 [3]
 [2,3]
 [1]
 [1,2]
 [1,3]
 [1,2,3]


[1]

start = end

[]
[1]


*/