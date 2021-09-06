package coursera.bst;

public class BST {

// Inorder traversal of a BST yields keys in ascending order.

    Node root;

    private Node put(Node x, int value)
    {
        if (x == null)
            return new Node(value, 1);

        if (value < x.value)
            x.left = put(x.left, value);
        else if (value > x.value)
            x.right = put(x.right, value);
        else if (value == x.value)
            x.value = value;

        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    // This facilitates efficient implementation of rank() and select()
    private int size(Node x)
    {
        if (x == null) return 0;
        return x.size;
    }

    // number of keys less than given key in bst.
    public int rank(int key){
        return rank(key, root);
    }

    private int rank(int key, Node x)
    {
        if (x == null) return 0;

        if (key < x.value)
            return rank(key, x.left);
        else if (key > x.value)
            return 1 + size(x.left) + rank(key, x.right);
        else if (key == x.value)
            return size(x.left);
        return -1;

    }

    public boolean contains(int key) {
        // todo : search if key exist in BST
        return true;
    }


    private class Node {
        int value;
        int size; // number of nodes in the subtree rooted to that node. (including that node)
        Node left;
        Node right;

        public Node(int value, int size) {
            this.value = value;
            this.size = size;
        }
    }

}
