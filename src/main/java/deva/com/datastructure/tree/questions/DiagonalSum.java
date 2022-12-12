package deva.com.datastructure.tree.questions;

import deva.com.datastructure.tree.BinaryNode;
import deva.com.datastructure.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class DiagonalSum {

    Tree tree;

    public static void main(String[] args) {
        DiagonalSum diagonalSum = new DiagonalSum();
        diagonalSum.execute();
    }

    private void execute() {
        tree = new Tree();
        tree.root = new BinaryNode(new BinaryNode(new BinaryNode(null,new BinaryNode(null,null, 10),9),
                new BinaryNode(new BinaryNode(null,null,11),null,6),2),
                new BinaryNode(new BinaryNode(new BinaryNode(null,null,12),
                        new BinaryNode(null,null,7),4), new BinaryNode(null,null, 5),3), 1);
        List<Integer> sums = new ArrayList<>();
        calculate(tree.root, sums, 0);
        System.out.println(sums);
    }

    private void calculate(BinaryNode node, List<Integer> sums, int index) {
        if(node == null)
            return;
        if(sums.size() < index + 1){
            sums.add(node.data);
        }else{
            sums.set(index,sums.get(index)+ node.data);
        }
        calculate(node.left,sums,index+1);
        calculate(node.right,sums, index);
    }


}
