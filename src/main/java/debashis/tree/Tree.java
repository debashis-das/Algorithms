package debashis.tree;

public class Tree {

    Node root;

    public Node createSampleTree(){
        root = new Node(null,6,null);
        root.left = new Node(null,3,null);
        root.right = new Node(null,5,null);
        root.left.left = new Node(null,2,null);
        root.left.right = new Node(null,5,null);
        root.left.right.left = new Node(null,7,null);
        root.left.right.right = new Node(null,4,null);
        root.right.right = new Node(null,4,null);
        return root;
    }

}
