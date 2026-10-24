class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0, len = s.length();
        int[] freq = new int[26];
        int maxFreq = 0;
        int maxLen = 0;
        for(int end=0;end<len;end++){
            char ch = s.charAt(end);
            freq[ch-'A']++;
            maxFreq = Math.max(maxFreq, freq[ch-'A']);
            while(end-start+1-maxFreq>k){
                freq[s.charAt(start)-'A']--;
                start++;
                for(int i=0;i<26;i++){
                    maxFreq = Math.max(maxFreq, freq[i]);
                }
            }
            maxLen = Math.max(maxLen, end-start+1);
        }
        return maxLen;
    }
}


/***


Element at start has the highest frequency
=> 2 scenarios
- Element at start has highest frequency even after removal and inser


(A,5) , (B,4)

start = B




The length of the longest substring which contains only one distinct character, after k replacements

"AAABABB"


Minimum number of replacements in a given substring to make all characters same
= length of the substring - frequency of the most frequent character = r

Substring considered valid solution when r<=k

Longest of such substring where r<=k


      "AAABABB"
start  ^
end    ^

How would I make it valid?

I'd make it valid by incrementing the start pointer

PriorityQueue of frequencies?
Why?
To make sure they are sorted in descending order
This is to make sure that when the current frequency is no longer the maximum
We get the next highest frequency
[0,1] [1,1]
How will I be handling insertions and deletions to this priority queue?


**/