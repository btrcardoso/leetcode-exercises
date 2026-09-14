// https://neetcode.io/problems/evaluate-reverse-polish-notation/question

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        return 0;
    }


// TODO: DFS
/* 

["4","13","5","/","+"]


+
right 
    /
    right
        5
    left
        13
    2
left
    4
6


*/

    // Space: O(n)
    // Time: O(n)
    public int evalRPN_stack(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Integer result = 0;

        for (int i = 0; i < tokens.length; i++) {

            while (i < tokens.length && 
                   !tokens[i].equals("+") && 
                   !tokens[i].equals("-") && 
                   !tokens[i].equals("*") && 
                   !tokens[i].equals("/")) {

                stack.push(Integer.parseInt(tokens[i]));
                i++;
            }

            Integer b = stack.pop();

            if (stack.isEmpty()) {
                stack.push(b);

            } else {
                Integer a = stack.pop();

                if (tokens[i].equals("+")) {
                    result = a + b;
                } else if (tokens[i].equals("-")) {
                    result = a - b;
                } else if (tokens[i].equals("*")) {
                    result = a * b;
                } else if (tokens[i].equals("/")) {
                    result = a / b;
                }

                stack.push(result);
            }

        }

        return stack.peek();        
    }
    
}
