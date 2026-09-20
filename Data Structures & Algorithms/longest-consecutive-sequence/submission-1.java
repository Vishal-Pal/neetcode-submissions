class Solution {
    public int longestConsecutive(int[] nums) {

        int maxLCS = 0;

        // Sort the array
        Arrays.sort(nums);

        // Maintain a map, of num, lcs
        Map<Integer, Integer> numLcsMap = new HashMap<>();

        // Calculation formula - lcs[num] = lcs[num-1]+1 or 1, if lcs[num-1] doesn't exist
        for(int num:nums){
            int prevNumLCS = numLcsMap.getOrDefault(num-1, 0);
            int currLCS = prevNumLCS+1;
            maxLCS = Math.max(maxLCS, currLCS);
            numLcsMap.put(num, currLCS);
        }

        return maxLCS;
    }
}
