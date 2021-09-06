package binaryTree.bst;

public class LCA {
    // https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/

    public static void main(String[] args) {
        LCA lca = new LCA();
    }


    //
    /*
    * Create a recursive function that takes a node and the two values n1 and n2.
If the value of the current node is less than both n1 and n2, then LCA lies in the right subtree. Call the recursive function for thr right subtree.
If the value of the current node is greater than both n1 and n2, then LCA lies in the left subtree. Call the recursive function for thr left subtree.
If both the above cases are false then return the current node as LCA.

    * */



    private class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
