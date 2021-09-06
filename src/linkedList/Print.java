package linkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class Print {
    public static void main(String[] args) {
        print1();

    }

    static void print1(){
        //Input : A>B>C>D>E
        //Output: A>E>B>D>C

        LinkedList<Character> linkedList = new LinkedList<>();
        linkedList.add('A');
        linkedList.add('B');
        linkedList.add('C');
        linkedList.add('D');
        linkedList.add('E');

        int i = 1;

        while(i < linkedList.size()){
            Character lastChar = linkedList.removeLast();
            linkedList.add(i, lastChar);
            i = i + 2;
        }


       linkedList.stream().forEach(System.out::println);
    }
}
