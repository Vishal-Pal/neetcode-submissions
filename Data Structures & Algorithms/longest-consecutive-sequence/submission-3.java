class Solution {
    public int longestConsecutive(int[] nums) {

        int maxLength = 0;

        // Maintain a set for O(1) look up
        Set<Integer> numSet = new HashSet<>();

        for(int num:nums){
            numSet.add(num);
        }

        for(int num:numSet){
            // Only consider this element, if its start of the sequence
            if(numSet.contains(num-1)){
                continue;
            }
            int length = 1;
            while(numSet.contains(num+length)){
                length++;
            }
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }
}
