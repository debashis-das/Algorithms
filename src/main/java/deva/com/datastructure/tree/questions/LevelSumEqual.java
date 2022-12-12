package deva.com.datastructure.tree.questions;

import deva.com.datastructure.tree.BinaryNode;
import deva.com.datastructure.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class LevelSumEqual {

    Tree tree;

    public static void main(String[] args) {
        LevelSumEqual levelSumEqual = new LevelSumEqual();
        levelSumEqual.execute();
    }

    public void execute(){
        Tree tree = new Tree();
        tree.root = new BinaryNode(new BinaryNode(new BinaryNode(null,null,4),
                new BinaryNode(null, null, 5),2),new BinaryNode(null,null,3),1);
        List<Integer> levelSums = new ArrayList<>();
        calculate(tree.root, levelSums, 0);
        int max = levelSums.stream().max(Integer::compare).get();
        levelSums.stream().forEach(value -> System.out.print(max-value+" "));
    }

    private void calculate(BinaryNode root, List<Integer> levelSums, int level) {
        if(root == null)
            return;
        if(levelSums.size() < level+1){
            levelSums.add(root.data);
        }else{
            levelSums.set(level,levelSums.get(level)+ root.data);
        }
        calculate(root.left, levelSums, level+1);
        calculate(root.right, levelSums, level+1);

    }
}
