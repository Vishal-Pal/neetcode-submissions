class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int start = 0;
        Map<Character, Integer> seen = new HashMap<>();
        int len = s.length();
        for(int end=0;end<len;end++){
            char ch = s.charAt(end);
            if(seen.containsKey(ch)){
                start = Math.max(start, seen.get(ch)+1);
            }
            seen.put(ch, end);
            maxLen = Math.max(maxLen, end-start+1);
        }
        return maxLen;
    }
}
