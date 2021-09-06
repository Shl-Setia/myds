package Heaps_PriorityQueues.seatingArrangement;

import java.util.*;

public class MergeKSortedLists2 {
    public static void main(String[] args) {

        int [][] input = {{1,5,7}, {2,3,10},{4,6,9}};
        MyIterator myIterator = new MyIterator(input);
        while (myIterator.hasNext()){
            System.out.println(myIterator.next());
        }


        /*Comparator<Holder> comparator = new Comparator<Holder>() {
            @Override
            public int compare(Holder o1, Holder o2) {
                return o1.val.compareTo(o2.val);
            }
        };

        PriorityQueue<Holder> pq = new PriorityQueue<>(comparator);

        System.out.println(input.length);


        for(int i =0; i< input.length; i++){
          pq.add(new Holder(input[i][0], i, 0));
        }

        while (!pq.isEmpty()){
            Holder holder = pq.poll();
            output.add(holder.val);
            if(holder.j < input[holder.i].length-1){ // if the list has next
                pq.add(new Holder(input[holder.i][holder.j+1], holder.i, holder.j+1));
            }
        }
        System.out.println(input[0].length);*/

    }

    static class Holder{
        public Integer val;
        public int i;
        public int j;

        public Holder(int val, int i, int j) {
            this.val = val;
            this.i = i;
            this.j = j;
        }
    }

    static class MyIterator<T> {

        int [][] input;
        List<Integer> output = new ArrayList<>();
        Iterator<Integer> iterator;

        public MyIterator(int [][] input){

            this.input = input;
            sort();
            this.iterator = output.iterator();
        }

        private  void sort(){

            Comparator<Holder> comparator = Comparator.comparing(o -> o.val);

            PriorityQueue<Holder> pq = new PriorityQueue<>(comparator);

           // System.out.println(input.length);


            for(int i =0; i< input.length; i++){
                pq.add(new Holder(input[i][0], i, 0));
            }

            while (!pq.isEmpty()){
                Holder holder = pq.poll();
                output.add(holder.val);
                if(holder.j < input[holder.i].length-1){ // if the list has next
                    pq.add(new Holder(input[holder.i][holder.j+1], holder.i, holder.j+1));
                }
            }
        }

        Integer next(){

            return iterator.next();
        }
        boolean hasNext(){
            return iterator.hasNext();
        }


    }

}
