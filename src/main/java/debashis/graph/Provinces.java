package debashis.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given an undirected graph with V vertices. We say two vertices u and v belong to a single province if there is a path from u to v or v to u. Your task is to find the number of provinces.
 *
 * Note: A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [1, 0, 1],
 *  [0, 1, 0],
 *  [1, 0, 1]
 * ]
 *
 * Output:
 * 2
 * Explanation:
 * The graph clearly has 2 Provinces [1,3] and [2]. As city 1 and city 3 has a path between them they belong to a single province. City 2 has no path to city 1 or city 3 hence it belongs to another province.
 * Example 2:
 * Input:
 * [
 *  [1, 1],
 *  [1, 1]
 * ]
 *
 * Output :
 * 1
 */
public class Provinces {

    public static void main(String[] args){
        Provinces provinces = new Provinces();
        int[][] graph1 = {{1, 0, 1},{0, 1, 0},{1, 0, 1}};
        System.out.println("provinces : "+provinces.noOfProvinces(graph1,3));
        System.out.println("----------");
        int[][] graph2 = {{1, 1},{1, 1}};
        System.out.println("provinces : "+ provinces.noOfProvinces(graph2,2));
    }

    /**
     * @param graph
     * @param noOfVertex
     * @return
     */
    public int noOfProvinces(int[][] graph,int noOfVertex){
        List<List<Integer>> newGraph = new ArrayList<>();
        boolean[] visited = new boolean[noOfVertex];
        int provinces = 0;

        for(int i = 0; i< noOfVertex; i++){
            List<Integer> connections = new ArrayList<>();
            for(int j = 0; j< noOfVertex; j++){
                if(i!=j && graph[i][j] == 1){
                    connections.add(j);
                }
            }
            newGraph.add(connections);
            if(connections.size() == 0) {
                ++provinces;
                visited[i] = true;
            }
        }

        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<noOfVertex;i++){
            if(visited[i])
                continue;
            stack.push(i);
            ++provinces;
            while(!stack.isEmpty()){
                int currentElement = stack.pop();
                visited[currentElement] = true;
                for(int temp : newGraph.get(currentElement)){
                    if(!visited[temp]){
                        stack.push(temp);
                    }
                }
            }
        }
        return provinces;
    }
}
