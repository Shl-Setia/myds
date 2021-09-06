package arrays.twoDimensional.intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeIntervals {

    public static void main(String[] args) {
        //int [][] in = {{1,3},{2,6},{8,10},{15,18}};

        Interval arr[]=new Interval[4];
        arr[0]= new Interval(1,3);
        arr[1] = new Interval(2,6);
        arr[2] = new Interval(8,10);
        arr[3] = new Interval(15,18);


        // sort them first and then iterate

        Arrays.sort(arr, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start != o2.start){
                   return o1.start - o2.start;
                }
                return o1.end - o2.end;
            }
        });


        Stack<Interval> stack = new Stack<>();
        stack.push(arr[0]);

        for(int i = 1; i< arr.length; i++){

            if(stack.peek().end >= arr[i].start){  // there is overlap
                // merge them
                stack.push(new Interval(stack.pop().start, arr[i].end));

            }else if(stack.peek().end < arr[i].end) {
                stack.push(arr[i]);
            }
        }

        stack.stream().forEach(interval -> System.out.println(interval.start + "," + interval.end));
    }


    static class Interval{
        public int start;
        public int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
