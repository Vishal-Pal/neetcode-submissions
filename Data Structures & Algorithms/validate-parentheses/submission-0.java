class Solution {
    public boolean isValid(String s) {
        
        // For easy checking
        Map<Character, Character> validParenthesesMap = new HashMap<>();
        validParenthesesMap.put(')','(');
        validParenthesesMap.put('}','{');
        validParenthesesMap.put(']','[');

        Deque<Character> paranthesesSt = new ArrayDeque<>();
        for(char bracket:s.toCharArray()){
            // Closing bracket found
            if(validParenthesesMap.containsKey(bracket)){
                if(paranthesesSt.isEmpty()){
                    return false;
                }
                char latestOpenBracket = paranthesesSt.peek();
                if(latestOpenBracket!=validParenthesesMap.get(bracket)){
                    return false;
                }
                paranthesesSt.pop();
            } else{
                paranthesesSt.push(bracket);
            }
        }

        return paranthesesSt.isEmpty();
    }
}

/**

Stack of elements

If I get an opening bracket
Then I'll push it to the stack

If I get a closing bracket
If the stack is empty
That means, no corresponding opening bracket
present for this bracket, so return false
Otherwise check the stack top, if its the matching bracket
then pop that, otherwise return false

At the end, check if the stack is empty
If it is, then all opening brackets were
closed by the corresponding closing brackets
so, return true, otherwise return false;

*/
