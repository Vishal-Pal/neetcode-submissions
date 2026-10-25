class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if(len1>len2){
            return false;
        }
        int[] freqS1 = new int[26];
        int[] freqSubS2 = new int[26];
        for(int i=0;i<len1;i++){
            freqS1[s1.charAt(i)-'a']++;
            freqSubS2[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(freqS1, freqSubS2)){
            return true;
        }
        for(int i=len1;i<len2;i++){
            freqSubS2[s2.charAt(i-len1)-'a']--;
            freqSubS2[s2.charAt(i)-'a']++;
            if(Arrays.equals(freqS1, freqSubS2)){
                return true;
            }
        }
        return false;
    }
}
