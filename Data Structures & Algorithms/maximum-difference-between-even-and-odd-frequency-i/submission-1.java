class Solution {
    public int maxDifference(String s) {
        int minEven = Integer.MAX_VALUE, minOdd = Integer.MAX_VALUE;
        int maxEven = Integer.MIN_VALUE, maxOdd = Integer.MIN_VALUE;
        int[] freq = new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        for(int i=0;i<26;i++){
            if(freq[i]==0){
                continue;
            }
            if(freq[i]%2==0){ //Even
                minEven = Math.min(minEven, freq[i]);
                maxEven = Math.max(maxEven, freq[i]);
            } else{
                minOdd = Math.min(minOdd, freq[i]);
                maxOdd = Math.max(maxOdd, freq[i]);
            }
        }
        return maxOdd-minEven;
    }
}