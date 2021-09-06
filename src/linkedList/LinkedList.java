package linkedList;

public class LinkedList {


    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(10);
        list.add(11);
        list.print();
       // list.reveseIt();
        list.insertAtPos(8, 9);
        list.print();
    }

    Node head;

    void add(int val){
        if(head == null){
            head = new Node(val, null);
        }else {
         findLastElement().next =    new Node(val, null);
        }


    }

     Node findLastElement(){
        if(head == null){
            return head;
        }
        Node last = head;
        while(last.next != null){
            last = last.next;
        }
        return last;
    }

    void print(){
        Node tmp = head;
        while(tmp != null){
            System.out.print(tmp.val);
            System.out.print("->");
            tmp = tmp.next;
        }
        System.out.println("null");
    }

    void printValueAndMemory(){
        Node tmp = head;
        while(tmp != null){
            System.out.print(tmp.toString());
            System.out.print("->");
            System.out.print(tmp.val);
            System.out.print("->");
            tmp = tmp.next;
        }
        System.out.println("null");
    }

    void print2(Node head){
        Node tmp = head;
        while(tmp != null){
            System.out.print(tmp.val);
            System.out.print("->");
            tmp = tmp.next;
        }
        System.out.println("null");
    }

    // reverse a list
    void reveseIt(){
        Node current = head;
        Node nextNode, tmp = null;

        while(current != null){
            nextNode = current.next;
            current.next = tmp;
            tmp = current;
            current = nextNode;

        }
        print2(tmp);
    }

    //insert at pos
    void insertAtPos(int pos, int val){
        // edge case pos is > then length of list

        if(pos == 1){
            Node next = head.next;
            head = new Node(val, next);
            return;
        }
        int count = 1;
        Node tmp = head;
        while(tmp != null){
            if(count == pos-1){
                // insert here and break;
                Node next = tmp.next;
                tmp.next = new Node(val, next);
                break;
            }
            count++;
            tmp = tmp.next;
        }

    }

    public class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (val != node.val) return false;
            return next != null ? next.equals(node.next) : node.next == null;
        }

        @Override
        public int hashCode() {
            int result = val;
            result = 31 * result + (next != null ? next.hashCode() : 0);
            return result;
        }
    }
}


