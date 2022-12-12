package deva.com.datastructure.tree;

import deva.com.datastructure.tree.util.TreeTraversal;

import java.util.List;

public class BinaryNode {

    public BinaryNode left;
    public BinaryNode right;
    public int data;

    public BinaryNode(BinaryNode left, BinaryNode right, int data){
        this.left = left;
        this.right = right;
        this.data = data;
    }


}
