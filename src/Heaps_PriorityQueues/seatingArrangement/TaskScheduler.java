package Heaps_PriorityQueues.seatingArrangement;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Stream;

//https://leetcode.com/problems/task-scheduler/
// Note : task name does not matter only their count matters
public class TaskScheduler {
    public static void main(String[] args) {

        char [] tasks = {'A','A','B', 'B'};
        int coolingTime = 2;

        int [] map = new int[26];

        for(char c : tasks){
            map[c - 'A']++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(26, Collections.reverseOrder());

        for(int f : map){
         queue.add(f);
        }


        int time =0;

        while(!queue.isEmpty()){

            int i =0;
            List< Integer > temp = new ArrayList< >();
            while(i<= coolingTime){

                if(!queue.isEmpty()){
                    if(queue.peek() > 1){
                        temp.add(queue.poll() -1);
                    }else {
                        queue.poll();
                    }
                }
                time++;
                if (queue.isEmpty() && temp.size() == 0)
                    break;
                i++;
            }

            for(int in : temp){
                queue.add(in);
            }

        }
        System.out.println(time);

    }
}
