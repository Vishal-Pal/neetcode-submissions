class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        int start = 0, maxFreq = 0;
        int len = s.length();
        for(int end=0;end<len;end++){
            char ch = s.charAt(end);
            freqMap.put(ch, freqMap.getOrDefault(ch,0)+1);
            maxFreq = Math.max(maxFreq, freqMap.get(ch));
            while(end-start+1-maxFreq>k){
                freqMap.put(s.charAt(start), freqMap.getOrDefault(s.charAt(start),0)-1);
                start++;
            }
            res = Math.max(res, end-start+1);
        }
        return res;
    }
}
