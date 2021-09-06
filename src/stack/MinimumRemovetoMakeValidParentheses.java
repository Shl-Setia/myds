package stack;

import java.util.Stack;

public class MinimumRemovetoMakeValidParentheses {
    public static void main(String[] args) {
        StringBuilder s  = new StringBuilder("lee(t(c)o)de)");

        Stack<Node> stack = new Stack<>();


        for(int i=0; i< s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(new Node(s.charAt(i) , i));
            }else if(s.charAt(i) == ')'){
                if(!stack.isEmpty() && stack.peek().c == '('){
                    stack.pop();
                }else {
                    stack.push(new Node(s.charAt(i) , i));
                }
            }
        }

        System.out.println("mini remove : " + stack.size());
        while (!stack.isEmpty()){
            s.deleteCharAt(stack.pop().index);
        }

        System.out.println(s.toString());

    }

    static class Node{
        char c;
        int index;

        public Node(char c, int index) {
            this.c = c;
            this.index = index;
        }
    }
}
