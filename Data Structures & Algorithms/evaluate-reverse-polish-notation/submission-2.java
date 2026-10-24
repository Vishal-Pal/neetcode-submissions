class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        Set<String> operators = new HashSet<>(Arrays.asList(new String[]{"+", "-", "*", "/"}));
        for (String token : tokens) {
            if (operators.contains(token)) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int res = apply(operand1, operand2, token);
                stack.push(res);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    private int apply(int operand1, int operand2, String operation) {
        switch (operation) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            default:
                return operand1 / operand2;
        }
    }
}
