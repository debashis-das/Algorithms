package debashis.graph;

import debashis.graph.represent.ArrayGraph;
import debashis.graph.represent.MapGraph;

import java.util.*;

/**
 * Map & Adj list based implementation
 */
public class DepthFirstSearch {

    Set<Integer> visited = new HashSet<>();
    List<Integer> values = new ArrayList<>();

    public static void main(String args[]){
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
//        mapBased(depthFirstSearch);
        adjacentListBased(depthFirstSearch);
    }
    /**Adjacent list based implementation**/
    private static void adjacentListBased(DepthFirstSearch depthFirstSearch) {
        // Creating a graph with 5 vertices
        ArrayGraph arrayGraph = new ArrayGraph(5);
        // Adding edges one by one
        arrayGraph.addEdge(0, 1);
        arrayGraph.addEdge( 0, 4);
        arrayGraph.addEdge( 1, 2);
        arrayGraph.addEdge( 1, 3);
        arrayGraph.addEdge( 1, 4);
        arrayGraph.addEdge( 2, 3);
        arrayGraph.addEdge( 3, 4);
//        arrayGraph.printGraph();
        depthFirstSearch.dfsAdjacentList(arrayGraph.getAdj()).stream().forEach(System.out::print);
    }

    private List<Integer> dfsAdjacentList(int[][] graph){
        boolean[] visited = new boolean[graph.length];
        List<Integer> result = new ArrayList<>();
        /**
         * out loop makes sure that no disjoint nodes and left
         */
        for(int i=0;i<graph.length;i++){
            if(visited[i])
                continue;
            Stack<Integer> stack = new Stack<>();
            stack.push(i);
            while(!stack.isEmpty()){
                int currentElement = stack.pop();
                result.add(currentElement);
                visited[currentElement] = true;
                for(int j=0;j<graph[currentElement].length;j++){
                    if(currentElement!=j && graph[currentElement][j] == 1 && !visited[j]){
                        stack.push(j);
                    }
                }
            }
        }
        return result;
    }

    /**Map based implementation**/

    private static void mapBased(DepthFirstSearch depthFirstSearch) {
        // graph init
        MapGraph graph = new MapGraph();
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        // DFS

        depthFirstSearch.dfsMapBased(0, graph.graph);
        depthFirstSearch.values.forEach(temp -> System.out.print(temp + " "));
    }


    private void dfsMapBased(int startNode, HashMap<Integer, TreeSet<Integer>> graph) {
        if(visited.contains(startNode)){
            return;
        }
        visited.add(startNode);
        values.add(startNode);
        for(int temp : graph.get(startNode)){
            if(visited.contains(temp)){
                continue;
            }
            dfsMapBased(temp,graph);
        }
    }


}
