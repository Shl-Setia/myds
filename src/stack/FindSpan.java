package stack;

import java.util.Arrays;
import java.util.Stack;

public class FindSpan {
    //https://leetcode.com/problems/online-stock-span/
    // span is max number of consecutive values before a[i] that are smaller than a[i]

    public static void main(String[] args) {
        int price[] = {100, 80, 60, 70, 60, 75, 85};
        Integer span[] = new Integer[price.length];

        Stack<Integer> stack = new Stack();

        stack.push(0); // note we are pushing index on the stack not value.
        span[0] = 1;

        for(int day = 1; day < price.length; day++){
            int top = price[stack.peek()];
            if(top > price[day]){ // ex. 100 > 80
                span[day] = 1; // current element is part of span
                stack.push(day); // push index to stack
            }else{
                int spans = 1; // one is for current element
                while(!stack.isEmpty() && price[stack.peek()] < price[day]){
                    int popedIndex = stack.pop();
                    int spanAtPopedIndex = span[popedIndex];
                    spans = spans + spanAtPopedIndex;
                }
                span[day] = spans;
                stack.push(day);
            }
        }

        System.out.println(price);
        System.out.println(Arrays.deepToString(span));

    }
}
