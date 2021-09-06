package mutliset;


import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

//https://leetcode.com/problems/find-median-from-data-stream/solution/
// using approach 4 - multiset
public class FindMedianFromStream {

    public static void main(String[] args) {
        Multiset<Integer> multiset = HashMultiset.create();


        Multiset<Integer> multiset2 = HashMultiset.create();

        multiset.add(4);
        multiset.add(4);
        multiset.add(1);
        multiset.add(2);
        multiset.add(2);
        multiset.add(2);



        System.out.println(multiset);
        System.out.println(multiset.size());

    }
}
