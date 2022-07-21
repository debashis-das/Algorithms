package debashis.graph;

import debashis.graph.represent.MapGraph;

import java.util.*;

public class DepthFirstSearch {

    Set<Integer> visited = new HashSet<>();
    List<Integer> values = new ArrayList<>();

    public static void main(String args[]){
        // graph init
        MapGraph graph = new MapGraph();
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
//        graph.printGraph();
        // DFS
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        depthFirstSearch.dfs(0, graph.graph);
        depthFirstSearch.values.forEach(temp -> System.out.print(temp + " "));
    }



    private void dfs(int startNode, HashMap<Integer, TreeSet<Integer>> graph) {
        if(visited.contains(startNode)){
            return;
        }
        visited.add(startNode);
        values.add(startNode);
        for(int temp : graph.get(startNode)){
            if(visited.contains(temp)){
                continue;
            }
            dfs(temp,graph);
        }
    }


}
