package stack;

// Dijkastra two stack solution for
// evaluating an arithematic expression.
// (One stack for values/operand and other for operator)

import java.util.Stack;

public class EvaluateExpressionDijkastra {


    public static void main(String[] args) {
        String  exp = "(1+((2+3)*(4*5)))";

        Stack<Integer> operand = new Stack<>();

        Stack<Character> operator = new Stack<>();

        char[] chars = exp.toCharArray();

        int i = 0;

        while(i < chars.length-1) {
            i++;
            if(chars[i] == '(')
                continue;

            if(chars[i] == '+' || chars[i] == '*') {
                operator.push(chars[i]);
            }
            else if(chars[i] == ')') {
                char ops = operator.pop();

                if(ops == '+'){
                    operand.push(operand.pop() + operand.pop());
                }
                else if(ops == '*'){
                    operand.push(operand.pop() * operand.pop());
                }
            } else {
                operand.push(Character.getNumericValue(chars[i]));
            }
        }


        System.out.println(operand.pop());
    }
}
