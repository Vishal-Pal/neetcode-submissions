class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        Set<String> operatorSet = new HashSet<>(Arrays.asList("+","-","*","/"));
        for(String token:tokens){
            if(operatorSet.contains(token)){
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = apply(operand1, operand2, token);
                stack.push(result);
            } else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private int apply(int operand1, int operand2, String operation){
        switch(operation){
            case "+":
            return operand1+operand2;
            case "-":
            return operand1-operand2;
            case "*":
            return operand1*operand2;
            case "/":
            return operand1/operand2;
            default:
            throw new UnsupportedOperationException("Invalid operation");
        }
    }
}
