package debashis.tree.problems;

import debashis.tree.Node;
import debashis.tree.Tree;

public class SumNumbersRootToLeaf {

    Integer sum;

    public static void main(String[] args) {
        SumNumbersRootToLeaf sumNumbersRootToLeaf = new SumNumbersRootToLeaf();
        sumNumbersRootToLeaf.sum = 0;
        Tree tree = new Tree();
        Node root = tree.createSampleTree();
        sumNumbersRootToLeaf.getSumsFromRootToLeaf(root, -1,true);
        System.out.println(sumNumbersRootToLeaf.sum);
    }

    private void getSumsFromRootToLeaf(Node node,Integer currentValue, boolean isRoot) {
        if(node == null)
            return;
        currentValue = isRoot ? node.value : currentValue+ node.value;
        if(node.left == null && node.right == null){
            sum+=currentValue;
        }
        getSumsFromRootToLeaf(node.left,currentValue*10,false);
        getSumsFromRootToLeaf(node.right,currentValue*10, false);
    }
}
