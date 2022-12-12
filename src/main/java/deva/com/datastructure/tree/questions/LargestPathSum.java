package deva.com.datastructure.tree.questions;

import deva.com.datastructure.tree.BinaryNode;
import deva.com.datastructure.tree.Tree;

public class LargestPathSum {

    Tree tree;

    int maxSum = Integer.MIN_VALUE;


    public static void main(String[] args) {
        LargestPathSum largestPathSum = new LargestPathSum();
        largestPathSum.execute();
    }

    public void execute(){
        Tree tree = new Tree();
//        tree.root = new BinaryNode(new BinaryNode(null,null,9),
//                new BinaryNode(new BinaryNode(null,null,15),
//                        new BinaryNode(null,null, 7),20), -10);
        tree.root = new BinaryNode(new BinaryNode(null,null,2),new BinaryNode(null,null,3),1);
        maxPathSum(tree.root);
        System.out.println(maxSum);
    }

    public int maxPathSum(BinaryNode node){
        if(node == null)
            return 0;
        int leftSum = maxPathSum(node.left);
        int rightSum = maxPathSum(node.right);
        if(maxSum<leftSum + rightSum + node.data){
            maxSum = leftSum + rightSum + node.data;
        }
        return node.data + Math.max(leftSum, rightSum);
    }
}
