package Heaps_PriorityQueues.seatingArrangement;

public class Node {
    int left;
    int right;
    int size;

    public Node(int left, int right, int size) {
        this.left = left;
        this.right = right;
        this.size = size;
    }

    public static Node copy(Node node){
        return new Node(node.left, node.right, node.size);
    }

}
