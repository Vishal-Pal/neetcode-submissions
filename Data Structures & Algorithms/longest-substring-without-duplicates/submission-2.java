class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int start = 0;
        Map<Character, Integer> seen = new HashMap<>();
        int len = s.length();
        for(int end=0;end<len;end++){
            char ch = s.charAt(end);
            if(seen.containsKey(ch)){
                int lastSeenAt = seen.get(ch);
                if(lastSeenAt>=start){
                    maxLen = Math.max(maxLen, end-start);
                    start = lastSeenAt+1;
                }
            }
            seen.put(ch, end);
        }
        maxLen = Math.max(maxLen, len-start);
        return maxLen;
    }
}
