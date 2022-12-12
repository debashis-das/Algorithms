package deva.com.datastructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreathFirstSearch {

    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addEdge(0,1,10);
        graph.addEdge(0,2,20);
        graph.addEdge(0,4,30);
        graph.addEdge(1,3,40);
        graph.addEdge(1,5,50);
        graph.addEdge(2,6,60);
        graph.addEdge(5,4,70);
        BreathFirstSearch bfs = new BreathFirstSearch();
        bfs.breathFirstSearch(graph.nodes,7);
    }

    public void breathFirstSearch(List<List<Node>> edges,int v){
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[v];
        for(int i=0;i<v;i++) {
            if (!visited[i]) {
                queue.offer(i);
                while(!queue.isEmpty()){
                    int current = queue.poll();
                    if(!visited[current]) {
                        result.add(current);
                        for(Node temp : edges.get(current)){
                            if(!visited[temp.index]){
                                queue.add(temp.index);
                            }
                        }
                    }
                    visited[current] = true;
                }
            }
        }
        for(int temp: result){
            System.out.print(temp+"->");
        }
    }
}
