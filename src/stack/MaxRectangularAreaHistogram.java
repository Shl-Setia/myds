package stack;


// intution is that keep on pushing index on to the stack if stack is empty or
// the next element is greater than stack top. Else, pop the element and calculate the rectangle area.

import java.util.Stack;

public class MaxRectangularAreaHistogram {

    public static void main(String[] args) {
        int hist[] = {6, 2, 5, 4, 5, 1, 6};
        //int hist[] = {2,1,5,6,2,3};

        Stack<Integer> stack = new Stack();

        int max_area = 0;
        int area = 0;
        int index ;
        for(index=0; index < hist.length;){ // note here we are not doing index++

            if(stack.isEmpty() || hist[index] >= hist[stack.peek()]){
                // next element is greater than top_area, so we push index to the stack
                stack.push(index);
                index++;
            }else {

                // keep poping the element from stack until this is not true hist[index] > hist[stack.top()]
                int popedIndex = stack.pop();
                if(stack.isEmpty()){
                    area = hist[popedIndex] * index;
                    System.out.println(String.format("area of bar of length %d and width %d is %d",  hist[popedIndex], index, area));
                }else{
                    area = hist[popedIndex] * (index - stack.peek() - 1);
                    System.out.println(String.format("area of bar of length %d and width %d is %d",  hist[popedIndex], (index - stack.peek() - 1), area));
                }
                if(area > max_area){
                    max_area = area;
                }
            }
        }

        while(!stack.isEmpty()){
            int popedIndex = stack.pop();
            if(stack.isEmpty()){
                area = hist[popedIndex] * index;
                System.out.println(String.format("area of bar of length %d and width %d is %d",  hist[popedIndex], index, area));
            }else{
                area = hist[popedIndex] * (index - stack.peek() - 1);
                System.out.println(String.format("area of bar of length %d and width %d is %d",  hist[popedIndex], (index - stack.peek() - 1), area));
            }
            if(area > max_area){
                max_area = area;
            }
        }
        System.out.println("--- " + max_area);
    }
}
