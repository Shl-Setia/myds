package Heaps_PriorityQueues.seatingArrangement;


//https://leetcode.com/problems/find-median-from-data-stream/solution/
// using approach 3 - priority queues
// two heaps solution

// PriorityQueue = Binary tree/heap
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromStream {
    public static void main(String[] args) {

    }

    Comparator<Integer> maxHeapComp = Comparator.reverseOrder();

    PriorityQueue<Integer> maxL = new PriorityQueue<>(maxHeapComp); // max(Left) heap for small n/2 values
    PriorityQueue<Integer> minR = new PriorityQueue<>(); //default is min(right) heap, it is for large n/2 values

    // if total elements = 2n, left and right both have n/
    // if total elements = 2n + 1, left must have n+1
    private void addNode(Integer val){
        maxL.add(val);
        minR.add(maxL.poll());
        if(minR.size() > maxL.size()){
            maxL.add(minR.poll());
        }
    }


    private double findMedian(){
        if(maxL.size() == minR.size()){
            return (double)(maxL.peek() + minR.peek()) * 0.5;
        }else {
            return maxL.peek();
        }
    }




}
