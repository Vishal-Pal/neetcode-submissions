class Solution {
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);
            if(isNonAlphaNumeric(startChar)) {
                start++;
                continue;
            }
            if(isNonAlphaNumeric(endChar)) {
                end--;
                continue;
            }
            startChar = convertToLowerCase(startChar);
            endChar = convertToLowerCase(endChar);
            if (startChar != endChar) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean isNonAlphaNumeric(char ch) {
        return ('A'>ch || ch>'Z') && ('a'>ch || ch>'z') && ('0'>ch || ch>'9');
    }

    private char convertToLowerCase(char ch){
        if('A'<=ch && ch<='Z'){
            return (char)((ch-'A')+'a');
        }
        return ch;
    }
}

/***

"wasitacaroracatisaw"
     ^          ^




*/
