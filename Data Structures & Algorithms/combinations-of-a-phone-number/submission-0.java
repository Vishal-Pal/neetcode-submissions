class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return Collections.emptyList();
        }
        Map<Character, char[]> digitMap = new HashMap<>();
        digitMap.put('2', new char[]{'a','b','c'});
        digitMap.put('3', new char[]{'d','e','f'});
        digitMap.put('4', new char[]{'g','h','i'});
        digitMap.put('5', new char[]{'j','k','l'});
        digitMap.put('6', new char[]{'m','n','o'});
        digitMap.put('7', new char[]{'p','q','r','s'});
        digitMap.put('8', new char[]{'t','u','v'});
        digitMap.put('9', new char[]{'w','x','y','z'});
        List<String> res = new ArrayList<>();
        backtrack(digits, 0, new StringBuilder(), res, digitMap);
        return res;
    }


    private void backtrack(String digits, int index, StringBuilder sb, List<String> res, Map<Character,  char[]> digitMap){
        if(index==digits.length()){
            res.add(new String(sb.toString()));
            return;
        }
        for(char ch:digitMap.get(digits.charAt(index))){
            sb.append(ch);
            backtrack(digits, index+1, sb, res, digitMap);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
