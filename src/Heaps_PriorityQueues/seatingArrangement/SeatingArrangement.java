package Heaps_PriorityQueues.seatingArrangement;

import java.util.ArrayList;
import java.util.List;

public class SeatingArrangement {
    public static void main(String[] args) {
        int n = 5; // chairs
        int k = 3; // person
        String s = "RLR"; // person sitting preference
        int q[] = {1,2,3,4,5}; // chair position query

        int chair[] = new int[n+1];

        int mid = find_mid(n,s.toCharArray(), 0);
        Node one = new Node(1, 2, 2);
        Node two = new Node(4, 5, 2);
        Node three = new Node(7, 8, 2);

        List<Node> heap = new ArrayList<>();
        heap.add(new Node(-1,-1,-1));
        heap.add(three);
        heap.add(two);
        heap.add(one);

        System.out.println(heap);

        max_heapify(heap, 1, heap.size()-1);




    }



    static void max_heapify(List<Node> heap, int index, int array_length){
        int left_child_in = 2*index;
        int right_child_in = 2*index + 1;

        int largest = index;

        if(left_child_in <= array_length && (heap.get(left_child_in).size > heap.get(index).size || heap.get(left_child_in).left < heap.get(index).left)){
            largest = left_child_in;
        }
        if(right_child_in <= array_length && (heap.get(right_child_in).size > heap.get(largest).size || heap.get(right_child_in).left < heap.get(largest).left)){
            largest = right_child_in;
        }
        if(largest != index){
            // swap them
            Node temp = Node.copy(heap.get(largest));
            heap.remove(largest);
            heap.add(largest, heap.get(index));
            heap.remove(index);
            heap.add(index, temp);

            max_heapify(heap, largest, array_length);
        }
    }

    static int find_mid(int n, char []pref, int person){
        if(n%2 == 0){// even
            if(pref[person] == 'R'){
                return n/2 + 1;
            }else {
                return n/2;
            }
        }else {
            return n/2 + 1;
        }
    }
}

