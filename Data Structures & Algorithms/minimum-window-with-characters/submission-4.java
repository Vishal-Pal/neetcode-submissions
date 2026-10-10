class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()){
            return "";
        }
        int len = s.length();
        int minLen = Integer.MAX_VALUE;
        int minStart = -1, minEnd = len;
        Map<Character, Integer> countT = new HashMap<>();
        for(char ch:t.toCharArray()){
            countT.put(ch, countT.getOrDefault(ch,0)+1);
        }
        int start = 0;
        int have = 0, need = countT.size();
        Map<Character, Integer> window = new HashMap<>();
        for(int end=0;end<len;end++){
            char ch = s.charAt(end);
            window.put(ch, window.getOrDefault(ch,0)+1);
            if(countT.containsKey(ch) && window.get(ch).equals(countT.get(ch))){
                have++;
            }
            // While the window is valid
            // Record the result if required
            // Shrink from the left
            while(have == need){
                int windowLen = end-start+1;
                if(windowLen<minLen){
                    // Record result
                    minStart = start;
                    minEnd = end;
                    minLen = windowLen;
                }
                // Shrink from the left
                char chStart = s.charAt(start);
                window.put(chStart, window.get(chStart)-1);
                start++;
                if(countT.containsKey(chStart) && window.get(chStart)<countT.get(chStart)){
                    have--;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "":s.substring(minStart, minEnd+1);
    }
}
