package deva.com.datastructure.graph.questions;

import deva.com.datastructure.graph.Graph;
import deva.com.datastructure.graph.Node;

import java.util.ArrayList;
import java.util.List;

public class IterativeDeepingDepthFirstSearch {

    public static void main(String[] args){
        Graph graph = new Graph(7);
        graph.addEdge(0,1,10);
        graph.addEdge(0,2,20);
        graph.addEdge(0,4,30);
        graph.addEdge(1,3,40);
        graph.addEdge(1,5,50);
        graph.addEdge(2,6,60);
        graph.addEdge(5,4,70);
        IterativeDeepingDepthFirstSearch iddfs = new IterativeDeepingDepthFirstSearch();
        boolean[] visited = new boolean[graph.vertices];
        List<Integer> result3 = new ArrayList<>();
        iddfs.iterativeDeepingDepthFirstSearch(graph.nodes,0,0,2,visited,result3);
        System.out.println(result3);
    }


    public void iterativeDeepingDepthFirstSearch(List<List<Node>> nodes, int startNode, int currentDepth,
                                                 int maxDepth, boolean visited[], List<Integer> result){
        if(currentDepth == maxDepth){
            if(!visited[startNode]) {
                visited[startNode] = true;
                result.add(startNode);
            }
        }else if(currentDepth < maxDepth){
            if(!visited[startNode]) {
                visited[startNode] = true;
                result.add(startNode);
            }
            for(Node temp : nodes.get(startNode))
                iterativeDeepingDepthFirstSearch(nodes,temp.index, currentDepth+1,maxDepth,visited,result);
        }
    }
}
