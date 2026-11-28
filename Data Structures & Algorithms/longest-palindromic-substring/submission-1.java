class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int[] res = {0,0};
        for(int ind=0;ind<len;ind++){
            longestPalindromeBounds(s, ind, ind, len, res);
            longestPalindromeBounds(s, ind, ind+1, len, res);
        }
        return s.substring(res[0], res[1]+1);
    }

    private void longestPalindromeBounds(String s, int start, int end, int len, int[] res){
        while(start>=0 && end<len && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        start++;
        end--;
        if(end-start<res[1]-res[0]){
            return;
        }
        res[0]=start;
        res[1]=end;
    }
}
