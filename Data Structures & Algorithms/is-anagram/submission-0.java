class Solution {
    public boolean isAnagram(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        if(lenS!=lenT){
            return false; // Unequal length string can't be anagrams
        }
        int[] freqS = new int[26];
        int[] freqT = new int[26];
        for(int i=0;i<lenS;i++){
            freqS[s.charAt(i)-'a']++;
            freqT[t.charAt(i)-'a']++;
        }
        return Arrays.equals(freqS, freqT);
    }
}

/***

Anagram - Same characters and same frequency

Constraint on the characters? Only lowercase or something like that?

Approach
Maintain a frequency array having frequency of each element

Some basic checks, like if lenS != lenT => Not an anagram
Iterate both strings and store frequency of the characters

At the end of iteration, if the frequency arrays are equal then it is anagram, otherwise it
is not an anagram

Frequency array of size 26, since there are 26 lowercase english characters

T.C - O(n), S.C - O(1) => Constant space (2 arrays of length 26)

*/