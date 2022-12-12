package deva.com.datastructure.tree;

import deva.com.datastructure.tree.util.TreeTraversal;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    public BinaryNode root;

    public List<Integer> printNodes(TreeTraversal treeTraversal){
        List<Integer> output = new ArrayList<>();
        switch (treeTraversal){
            case inorder:
                inorder(root, output);
                break;
            case preorder:
                preorder(root, output);
                break;
            case postorder:
                postorder(root, output);
                break;
            default:
                break;
        }
        return output;
    }

    private void inorder(BinaryNode node,List<Integer> output){
        if(node == null)
            return;
        inorder(node.left,output);
        output.add(node.data);
        inorder(node.right,output);
    }

    private void preorder(BinaryNode node,List<Integer> output){
        if(node == null)
            return;
        output.add(node.data);
        inorder(node.left,output);
        inorder(node.right,output);
    }

    private void postorder(BinaryNode node,List<Integer> output){
        if(node == null)
            return;
        inorder(node.left,output);
        inorder(node.right,output);
        output.add(node.data);
    }

}
