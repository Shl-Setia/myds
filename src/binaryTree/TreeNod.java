package binaryTree;

public class TreeNod {
    public int val;
    public TreeNod left;
    public TreeNod right;
    public TreeNod() {}
    public TreeNod(int val) { this.val = val; }
    public TreeNod(int val, TreeNod left, TreeNod right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
