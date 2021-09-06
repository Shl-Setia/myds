package Heaps_PriorityQueues.seatingArrangement;

import java.util.*;

public class MergeKSortedLists {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,4,5);
        List<Integer> list2 = Arrays.asList(1,3,4);
        List<Integer> list3 = Arrays.asList(2,6);
        List<Integer>  finalList = new ArrayList<>();


        Comparator<Twins> comparator = Comparator.comparing(Twins::getKey);
        PriorityQueue<Twins> priorityQueue = new PriorityQueue<>(comparator);

        int k = 3;
        Iterator<Integer> iterator1 = list1.iterator();
        Iterator<Integer> iterator2 = list2.iterator();
        Iterator<Integer> iterator3 = list3.iterator();

        // pick first element from each list and ad in PQ.
        priorityQueue.add(new Twins(iterator1.next(), iterator1));
        priorityQueue.add(new Twins(iterator2.next(), iterator2));
        priorityQueue.add(new Twins(iterator3.next(), iterator3));

        // Use single LinkedList( queue) so that we dont need to used iterator

        while(!priorityQueue.isEmpty()){
            Twins poll = priorityQueue.poll();
            finalList.add(poll.key);
            if(poll.iterator.hasNext()){
              priorityQueue.add(new Twins(poll.iterator.next(), poll.iterator));
            }

        }


        finalList.forEach(System.out::println);

    }

    static class Twins{

        Integer key;
        Iterator<Integer> iterator;

        public Twins(Integer key, Iterator<Integer> iterator) {
            this.key = key;
            this.iterator = iterator;
        }

        public Integer getKey() {
            return key;
        }

        public Iterator<Integer> getIterator() {
            return iterator;
        }

        @Override
        public String toString() {
            return "Twins{" +
                    "key=" + key +
                    '}';
        }
    }
}
