class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if(len1>len2){
            return false;
        }
        int[] freqS1 = new int[26];
        int[] freqS2 = new int[26];
        for(int ind=0;ind<len1;ind++){
            freqS1[s1.charAt(ind)-'a']++;
            freqS2[s2.charAt(ind)-'a']++;
        }
        if(Arrays.equals(freqS1, freqS2)){
            return true;
        }
        int start = 0;
        for(int end=len1;end<len2;end++){
            freqS2[s2.charAt(start)-'a']--;
            freqS2[s2.charAt(end)-'a']++;
            if(Arrays.equals(freqS1, freqS2)){
                return true;
            }
            start++;
        }
        return false;
    }
}
