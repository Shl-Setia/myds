package stack;


import java.util.Stack;

//https://leetcode.com/problems/valid-parenthesis-string/
//https://www.youtube.com/watch?v=KuE_Cn3xhxI
public class ValidParenthesisString {
    public static void main(String[] args) {

        String s = "***(()";

        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();

        // first process the string and closing bracket')'
        for(int i =0 ; i< s.length(); i++){
            char c = s.charAt(i);
            if( c == '('){
                open.push(i);
            }else if(c == '*'){
                star.push(i);
            }else{
                if(!open.isEmpty()){
                    open.pop();
                }else if(!star.isEmpty()){
                    star.pop();
                }else {
                    System.out.println("not a valid string");
                    break;
                }
            }
        }// end of for loop


        // now process pending left bracket '('
        while(!open.isEmpty()){
            int leftBracketIndex = open.pop();
            // there must be star with index greater than left bracket index
            if(star.isEmpty() || star.peek() < leftBracketIndex){
                System.out.println("not a valid string..");
                break;
            }else{
                star.pop();
            }
        }

        System.out.println("valid");
    }
}
