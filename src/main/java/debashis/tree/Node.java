package debashis.tree;

public class Node {

    public Node left;
    public int value;
    public Node right;

    public Node(Node left,int value,Node right) {
        this.left = left;
        this.value = value;
        this.right = right;
    }
}
