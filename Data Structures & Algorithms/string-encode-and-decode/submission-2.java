class Solution {

    private static final String EMPTY_STRING_PLACEHOLDER="?";
    private static final String STRING_DELIMITER=";";
    private static final String CHAR_DELIMITER=":";

    public String encode(List<String> strs) {
        if(strs == null
        || strs.isEmpty()){
            return "";
        }
        StringBuilder encodedSb = new StringBuilder();
        int noOfStrings = strs.size();
        for(int stringNo=0;stringNo<noOfStrings;stringNo++){
            String str = strs.get(stringNo);
            if(str.isEmpty()){
                encodedSb.append(EMPTY_STRING_PLACEHOLDER);
                encodedSb.append(STRING_DELIMITER);
                continue;
            }
            char[] strCharArray = str.toCharArray();
            int noOfChars = strCharArray.length;
            for(int charNo=0;charNo<noOfChars;charNo++){
                char ch = strCharArray[charNo];
                encodedSb.append(toASCIIDecimal(ch));
                if(charNo!=noOfChars-1){
                    encodedSb.append(CHAR_DELIMITER);
                }
            }
            if(stringNo!=noOfStrings-1){
                encodedSb.append(STRING_DELIMITER);
            }
        }
        System.out.println(encodedSb.toString());
        return encodedSb.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedStrs = new ArrayList<>();
        if(str.isEmpty()){
            return decodedStrs;
        }
        String[] asciiStrings = str.split(STRING_DELIMITER);
        StringBuilder decodedSb = new StringBuilder();
        for(String asciiString:asciiStrings){
            if(EMPTY_STRING_PLACEHOLDER.equals(asciiString)){
                decodedStrs.add(decodedSb.toString());
                continue;    
            }
            String[] asciiChars = asciiString.split(CHAR_DELIMITER);
            for(String asciiChar:asciiChars){
                decodedSb.append(fromASCIIDecimal(asciiChar));
            }
            decodedStrs.add(decodedSb.toString());
            decodedSb.setLength(0);
        }
        return decodedStrs;
    }

    private int toASCIIDecimal(char ch){
        return (int)ch;
    }

    private String fromASCIIDecimal(String d){
        return (d==null || d.isEmpty()) ? "":String.valueOf((char) Integer.parseInt(d));
    }
}
