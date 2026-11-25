class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        if(length == 1){
            return s;
        }
        String res = String.valueOf(s.charAt(0));
        int maxLength = 1;
        Set<String> seen = new HashSet<>();
        for(int start=0;start<length;start++){
            for(int end=start+1;end<length;end++){
                int len = end-start+1;
                if(len<=maxLength){
                    continue;
                }
                String substr = s.substring(start, end+1);
                if(seen.contains(substr) || !isPalindrome(substr)){
                    continue;
                }
                seen.add(substr);
                res = substr;
                maxLength = len;
            }
        }
        return res;
    }

    private boolean isPalindrome(String s){
        int start = 0, end = s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

/**


"ababd"

Check every substring of the array for palindrome
and if the array is palindrome, then update a global maxlength

*/