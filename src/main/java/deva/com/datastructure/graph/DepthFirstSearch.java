package deva.com.datastructure.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {

    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addDirectedEdge(0,1,10);
        graph.addDirectedEdge(0,2,20);
        graph.addDirectedEdge(0,4,30);
        graph.addDirectedEdge(1,3,40);
        graph.addDirectedEdge(1,5,50);
        graph.addDirectedEdge(2,6,60);
        graph.addDirectedEdge(5,4,70);
        DepthFirstSearch dfs = new DepthFirstSearch();
        dfs.depthFirstSearch(graph.nodes,7);
    }

    private void depthFirstSearch(List<List<Node>> nodes, int v) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[v];
        for(int i=v-1;i>=0;i--){
            if(!visited[i]){
                stack.push(i);
                while(!stack.isEmpty()){
                    int current = stack.pop();
                    if(!visited[current]){
                        result.add(current);
                        for(Node temp : nodes.get(current)){
                            if(!visited[temp.index]){
                                stack.push(temp.index);
                            }
                        }
                    }
                    visited[current] = true;
                }
            }
        }
        for(int temp: result){
            System.out.print(temp+" ");
        }
    }
}
