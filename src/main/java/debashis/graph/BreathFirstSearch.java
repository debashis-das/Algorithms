package debashis.graph;

import debashis.graph.represent.MapGraph;

import java.util.*;

public class BreathFirstSearch {

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
        // BFS
        BreathFirstSearch breathFirstSearch = new BreathFirstSearch();
        breathFirstSearch.bfs(0, graph.graph);
        breathFirstSearch.values.forEach(temp -> System.out.print(temp + " "));
    }

    private void bfs(int startNode, HashMap<Integer, TreeSet<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        while (!queue.isEmpty()){
            int temp = queue.remove();
            if(!visited.contains(temp)) {
                values.add(temp);
                visited.add(temp);
            }
            for(int i : graph.get(temp)) {
                if(!visited.contains(i))
                    queue.add(i);
            }
        }
    }
}
