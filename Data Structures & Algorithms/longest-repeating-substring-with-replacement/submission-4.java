class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int maxStreak = 0;
        int start = 0;
        int[] freq = new int[26];
        for(int end=0;end<len;end++){
            freq[s.charAt(end)-'A']++;
            int maxFreq = Arrays.stream(freq).max().getAsInt();
            while(end-start+1-maxFreq>k){
                freq[s.charAt(start)-'A']--;
                maxFreq = Arrays.stream(freq).max().getAsInt();
                start++;
            }
            maxStreak = Math.max(maxStreak, end-start+1);
        }
        return maxStreak;
    }
}
