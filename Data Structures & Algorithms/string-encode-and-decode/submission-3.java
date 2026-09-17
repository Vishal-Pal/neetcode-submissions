class Solution {

    // LENGTH PREFIX APPROACH
    private static final char LENGTH_DELIMITER='#';

    public String encode(List<String> strs) {
        if(strs == null
        || strs.isEmpty()){
            return "";
        }
        StringBuilder encodedSb = new StringBuilder();
        for(String str:strs){
            int len = str.length();
            encodedSb.append(len);
            encodedSb.append(LENGTH_DELIMITER);
            encodedSb.append(str);
        }
        return encodedSb.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedStrs = new ArrayList<>();
        if(str.isEmpty()){
            return decodedStrs;
        }
        StringBuilder sb = new StringBuilder();
        int itr = 0, len = str.length();
        while(itr<len){
            // Extract length of current string
            while(itr<len && str.charAt(itr)!=LENGTH_DELIMITER){
                sb.append(str.charAt(itr));
                itr++;
            }
            // Convert length to integer
            int currStrLen = Integer.parseInt(sb.toString());
            // Clear stringbuilder for reuse
            sb.setLength(0);
            int endOfCurrStr = itr+currStrLen;
            // Form the current string
            for(int ind=itr+1;ind<=endOfCurrStr;ind++){
                sb.append(str.charAt(ind));
            }
            // Add the string to result
            decodedStrs.add(sb.toString());
            // Clear stringbuilder for reuse
            sb.setLength(0);
            // Move iterator to the end of current string's next character
            itr = endOfCurrStr+1;
        }
        return decodedStrs;
    }
}
