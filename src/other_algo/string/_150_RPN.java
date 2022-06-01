package other_algo.string;

import java.util.Stack;

/*
        150. Evaluate Reverse Polish Notation
Medium

3146

636

Add to List

Share
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, and /. Each operand may be an integer or another expression.

Note that division between two integers should truncate toward zero.

It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.



Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
 */
public class _150_RPN {
    public static void main(String[] args) {
       // String[] token = {"2","1","+","3","*"};
       String[] token = {"4","13","5","/","+"};
        System.out.println(reversePolishNotion(token));
    }

    private static String reversePolishNotion(String[] token) {
        Stack<String> stack = new Stack<>();

        for (String s : token) {
            if (isExpression(s)) {
                String item2 = stack.pop();
                String item1 = stack.pop();
                String result = "";
                switch (s) {
                    case "+":
                        result = (Integer.parseInt(item1) + Integer.parseInt(item2)) + "";
                        break;
                    case "-":
                        result = (Integer.parseInt(item1) - Integer.parseInt(item2)) + "";
                        break;
                    case "/":
                        result = (Integer.parseInt(item1) / Integer.parseInt(item2)) + "";
                        break;
                    default:  // "*"
                        result = (Integer.parseInt(item1) * Integer.parseInt(item2)) + "";
                        break;
                }
                stack.push(result);
            } else {
                stack.push(s);
            }
        }

        return stack.pop();
    }

    private static boolean isExpression(String str) {
        return  (str.equals("+") || str.equals("-") || str.equals("/") || str.equals("*"));
    }
}
