package stack;


//https://www.geeksforgeeks.org/next-greater-element/
//https://www.youtube.com/watch?v=8P-Z7Oc8x9I

// Idea is if input is 11,9,8,7,6,19 then NGE of 11,9,8,7,6 is 19.  So we need to keep 11,9,8,7,6 on stack until 19 is reached

import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int [] arr = {98,23,54,12,20,7,6,5,27};
        int [] result = new int[arr.length];

        Stack<Integer> stack = new Stack();
        stack.push(arr[0]); // push first element on the stack

        for(int i=1; i< arr.length ; i++){
            int next = arr[i];
            if(!stack.isEmpty()){
                if(next < stack.peek()){ // next  element is smaller than stack top
                    stack.push(next);

                }else {

                    while (next > stack.peek() && !stack.isEmpty()){
                       System.out.println("next greater element of " + stack.peek() + " is -> " + next);
                       stack.pop();
                    }
                    stack.push(next);
                }
            }
        }

        System.out.println();
    }



    /*static class Stack {
        int top = -1;
        int[] items = new int[100];


        void push(int x){
            if(top == items.length-1){
                System.out.println("Stack full");
            }else {
                items[++top]=x;
            }
        }

        int pop(){
            if(top == -1){
                System.out.println("Underflow error");
                return -1;
            }else{
                int element = items[top];
                items[top] = 0;
                top--;
                return element;
            }
        }

        int top(){
            if(top == -1){
                System.out.println("Underflow error");
                return -1;
            }else{
                return items[top];
            }
        }

        boolean isEmpty()
        {
            return (top == -1) ? true : false;
        }


        void pushAtBottom(int x){
            if(this.isEmpty()){
                this.push(x);
                return;
            }

            int tmp = this.pop();
            pushAtBottom(x);
            this.push(tmp);

        }
    }*/



}
