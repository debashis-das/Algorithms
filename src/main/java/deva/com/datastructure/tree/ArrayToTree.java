package deva.com.datastructure.tree;

import deva.com.datastructure.tree.util.TreeTraversal;

public class ArrayToTree {

    public static void main(String[] args){
        int[] input = {1,2,3,4,5,6,7,8,9};
        ArrayToTree arrayToTree = new ArrayToTree();
        Tree tree = new Tree();
        tree.root = arrayToTree.convertToBalancedTree(input,0,input.length-1);
        System.out.println(tree.printNodes(TreeTraversal.preorder));
        System.out.println(tree.printNodes(TreeTraversal.inorder));
        System.out.println(tree.printNodes(TreeTraversal.postorder));
    }

    private BinaryNode convertToBalancedTree(int[] inputs,int leftIndex,int rightIndex){
        if(leftIndex>rightIndex)
            return null;
        if(leftIndex == rightIndex)
            return new BinaryNode(null,null,inputs[leftIndex]);
        int mid = (leftIndex + rightIndex)/2;
        BinaryNode node = new BinaryNode(convertToBalancedTree(inputs,leftIndex,mid-1)
                ,convertToBalancedTree(inputs,mid+1,rightIndex),inputs[mid]);
        return node;
    }
}
