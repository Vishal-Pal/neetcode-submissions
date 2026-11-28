class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        int numPalindromes = len;
        Map<String, Boolean> palindromeMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int ind=0;ind<len;ind++){
            // Odd length palindromes
            numPalindromes+=palindromeCount(s, ind-1, ind+1, len);
            // Even length palindromes
            numPalindromes+=palindromeCount(s, ind, ind+1, len);
        }
        return numPalindromes;
    }

    private int palindromeCount(String s, int start, int end, int len){
        int count = 0;
        while(start>=0 && end<len){
            if(s.charAt(start)!=s.charAt(end)){
                break;
            }
            count++;
            start--;
            end++;
        }
        return count;
    }
}


/***


"abccba"
 ^
  ^
 requiredMatches = 2

Center of palindrome
And I extend in both directions only when my boundary characters are same

How will I handle odd and even lengths?


abdfdsjifjsdifjicdfjsdfojdsfccccdokfosdkfodskfok
                             ^



1 ccc

2 bcc

3 ccb

4 bcd

5 bcb

1=5? Odd length palindromes - I can extend in both directions?
Why?

cbcbb

Odd length palindromes - I have to extend both directions and check whether it is palindromic

Even length palindromes
bcc/ ccb

Extend in a single direction


Edge cases
ind = 0 -> Cannot extend to the left

"aba"
"aab"
"abc"
"aaa"



*/
