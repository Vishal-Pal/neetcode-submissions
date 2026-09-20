class Solution {
    public int longestConsecutive(int[] nums) {

        int maxLCS = 0;

        // Maintain a map, of num, lcs
        Map<Integer, Integer> numLcsMap = new HashMap<>();

        for(int num:nums){
            // Skip duplicates
            if(numLcsMap.containsKey(num)){
                continue;
            }
            // Find previous LCS and next number LCS
            int prevNumLCS = numLcsMap.getOrDefault(num-1, 0);
            int nextNumLCS = numLcsMap.getOrDefault(num+1, 0);
            // Num shall be appended to the end of the previous number's LCS
            // and the beginning of the next number's LCS
            int currLCS = prevNumLCS+nextNumLCS+1;
            maxLCS = Math.max(maxLCS, currLCS);
            numLcsMap.put(num, currLCS);
            // Number of numbers b/w n1 and n2 inclusive = n2-n1+1
            // Since the numbers in LCS are consecutive
            // So, if LCS of n-1, including n-1 is x
            // then the lowest number will be (n-1)-n1+1=x=>n1=n-x
            int lowerBoundOfCurrLCS = num-prevNumLCS;
            numLcsMap.put(lowerBoundOfCurrLCS, currLCS);
            // Since the numbers in LCS are consecutive
            // So, if LCS of n+1, including n+1 is x
            // then the highest number will be n2-(n+1)+1=x=>n+x
            int upperBoundOfCurrLCS = num+nextNumLCS;
            numLcsMap.put(upperBoundOfCurrLCS, currLCS);
        }

        return maxLCS;
    }
}
