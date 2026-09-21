class Solution {
    public boolean isValid(String s) {
        // For easy checking
        Map<Character, Character> closeToOpenMap = new HashMap<>();
        closeToOpenMap.put(')', '(');
        closeToOpenMap.put('}', '{');
        closeToOpenMap.put(']', '[');

        Deque<Character> stack = new ArrayDeque<>();
        for (char bracket : s.toCharArray()) {
            // Closing bracket found
            if (closeToOpenMap.containsKey(bracket)) {
                if (!stack.isEmpty() && stack.peek() == closeToOpenMap.get(bracket)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(bracket);
            }
        }

        return stack.isEmpty();
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
