package linkedList;

public class FindIntersection {

    // given two linked list of size m,n find the intersection point.

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();

        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);

        l2.add(5);
        l2.add(6);
        l2.add(7);

        // creating intersected lists
        l2.head.next.next.next = l1.head.next.next;

        l1.printValueAndMemory();
        l2.printValueAndMemory();
        findIntersection(l1, l2);

    }

    static void findIntersection(LinkedList l1, LinkedList l2){
        // option 1
        // create array of size of l1 + l2
        // store address instead of val in the array
        // assume address is an integer, then find the first element that is repeating  in the array


        // option 2.

        int len1 = 0;
        LinkedList.Node tmp = l1.head;

        // find length of first
        while(tmp != null){
            len1++;
            tmp = tmp.next;
        }

        int len2 = 0;
        tmp = l2.head;

        // find length of second
        while(tmp != null){
            len2++;
            tmp = tmp.next;
        }

        LinkedList.Node firstlist = null;
        LinkedList.Node secondlist = null;


        // find diff
        int diff;
        if(len1 > len2){
            firstlist = l1.head;
            secondlist = l2.head;
            diff = len1 - len2;
        }else {
            firstlist = l2.head;
            secondlist = l1.head;
            diff = len2 - len1;
        }

        // move the pointer of first list, long one,  to diff

        for(int i = 0;  i<diff; i++){
            firstlist = firstlist.next;
        }

        while (firstlist != null || secondlist != null){
            if(firstlist.equals(secondlist)){
                System.out.println("found the intersection point");
                System.out.println(firstlist.toString());
                break;
            }
            firstlist = firstlist.next;
            secondlist = secondlist.next;
        }

    }


    static void findFirstRepeatingNumberInArray(){
        int [] arr = {1,2,3,4,4,6,7,3,4};
        // ans is 3 not not 4

    }
}
