package coursera.bst;

public class LLRBTree {

    // If implemented properly,
    // the height of a red-black BST with N keys is at most 2 lg N

    private static final boolean BLACK = false;
    private static final boolean RED   = true;

    private Node root;

    // Same code for all cases.
    // Right child red, left child black: rotate left.
    // Left child, left-left grandchild red: rotate right.
    // Both children red: flip colors.



    private Node put(Node h, int  key, int val) {
        if (h == null)
            return new Node(key, val, RED); // default color is red.

        if(key > h.key) {
            h.right = put(h.right, key, val);
        }else if(key < h.key) {
            h.left = put(h.left, key, val);
        }else if(key == h.key) {
            h.value = val; // update the value
        }

        if(isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if(isRed(h.left) && isRed(h.left.left) ){
            h= rotateRight(h);
        }
        if(isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        return h;
    }

    public int getValue(int key) {
        Node x = root;

        while (x != null) {
            if(x.key == key) {
                return x.value;
            }else if(key > x.key) {
                x = x.right;
            }else if(key < x.key) {
                x = x.left;
            }
        }
        return -1;
    }


    private boolean isRed(Node x)
    {
        if (x == null) return false; // null links are blank
        return x.color == RED;
    }


    private Node rotateLeft(Node h)
    {
        assert isRed(h.right);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }


    private Node rotateRight(Node h)
    {
        assert isRed(h.left);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }


    private void flipColors(Node h)
    {
        assert !isRed(h);
        assert isRed(h.left);
        assert isRed(h.right);
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }


    private class Node {
        // key and value for symbol tables.
        int key;
        int value;
        Node left;
        Node right;
        boolean color; // color of parent link

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node(int key, int value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }

        public Node(int key, int value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }


}
