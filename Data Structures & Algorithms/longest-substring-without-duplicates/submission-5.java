class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen=0;
        Map<Character, Integer> lastSeenAtIndex = new HashMap<>();
        int start = 0;
        for(int end=0;end<s.length();end++){
            char ch = s.charAt(end);
            if(lastSeenAtIndex.containsKey(ch) && lastSeenAtIndex.get(ch)>=start){
                start = lastSeenAtIndex.get(ch)+1;
            }
            lastSeenAtIndex.put(ch, end);
            maxLen = Math.max(maxLen, end-start+1);
        }
        return maxLen;
    }
}


/***

"zxyzxyz"

start = 0

end = 0
(z,0),(x,1),(y,2)


Maintain a lastSeenAtIndex Map

()
Whether the character is there and if it is
Then whether lastSeenIndex >= start -> This element has been previously seen in the current window
Or lastSeenIndex < start => Then we can safely ignore that index

start = prevIndex+1

*/
