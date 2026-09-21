class Solution {
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            while (start < end && isNonAlphaNumeric(s.charAt(start))) {
                start++;
            }
            while (end > start && isNonAlphaNumeric(s.charAt(end))) {
                end--;
            }
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean isNonAlphaNumeric(char ch) {
        return ('A' > ch || ch > 'Z') && ('a' > ch || ch > 'z') && ('0' > ch || ch > '9');
    }
}