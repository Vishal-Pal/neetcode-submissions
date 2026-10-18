class Solution {
    private char STRING_DELIMITER = '#';
    public String encode(List<String> strs) {
        if(strs == null || strs.isEmpty()){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(String str:strs){
            sb.append(str.length());
            sb.append(STRING_DELIMITER);
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if(str == ""){
            return Collections.emptyList();
        }
        List<String> strs = new ArrayList<>();
        int ptr = 0, length = str.length();
        StringBuilder sb = new StringBuilder();
        while(ptr<length){
            while(ptr<length && str.charAt(ptr)!=STRING_DELIMITER){
                sb.append(str.charAt(ptr));
                ptr++;
            }
            int len = Integer.valueOf(sb.toString());
            sb.setLength(0);
            String word = str.substring(ptr+1, ptr+len+1);
            strs.add(word);
            ptr+=len+1;
        }
        return strs;
    }
}


/***

In the encoding, append the length of string, then a hash
then the string and so on for all the strings

["Hello","World"]

5#Hello5#World
 ^
01234567890123

 start = ptr+1
 end = start+len
Length of the string
String word = str.substring(ptr, ptr+len)
ptr+=len



*/