package deva.com.datastructure.graph.questions;

import deva.com.datastructure.graph.Graph;
import deva.com.datastructure.graph.Node;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TransitiveClosure {

    public static Graph graph;

    public static void main(String[] args){
        graph = new Graph(4);
        graph.addDirectedEdge(0,1,-1);
        graph.addDirectedEdge(0,2,-1);
        graph.addDirectedEdge(1,2,-1);
        graph.addDirectedEdge(2,0,-1);
        graph.addDirectedEdge(2,3,-1);
        TransitiveClosure transitiveClosure = new TransitiveClosure();
        transitiveClosure.transitiveClosureMatrix();
    }

    public void transitiveClosureMatrix() {
        int[][] result = new int[4][4];
        boolean[] visited = new boolean[graph.vertices];
        for(int i=0;i< graph.vertices;i++){
            if(!visited[i])
                dfsUtil(i,new HashSet<>(),result);
        }
        for(int i=0;i< graph.vertices;i++){
            for(int j=0;j< graph.vertices;j++){
                if(i==j)
                    System.out.print(1+ " ");
                else
                    System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void dfsUtil(int startNode, Set<Integer> parentNodes, int[][] result) {
        if(parentNodes.contains(startNode))
            return;
        for(Node temp : graph.nodes.get(startNode)){
            parentNodes.add(startNode);
            dfsUtil(temp.index,parentNodes,result);
            parentNodes.remove(Integer.valueOf(startNode));
        }
        for(int temp : parentNodes)
            result[temp][startNode] = 1;
    }
}
